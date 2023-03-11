package com.example.gceolmcq.activities

//import com.example.gceolmcq.datamodels.SectionAnsweredScoreData
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gceolmcq.R
import com.example.gceolmcq.adapters.SectionNavigationRecyclerViewAdapter
import com.example.gceolmcq.datamodels.ExamItemDataModel
import com.example.gceolmcq.datamodels.SectionResultData
import com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData
import com.example.gceolmcq.fragments.*
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.example.gceolmcq.viewmodels.PaperActivityViewModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.*
import java.io.IOException
import java.nio.charset.Charset
private const val SHOW_INSTRUCTION = "showInstruction"

class PaperActivity : AppCompatActivity(),
    SectionNavigationRecyclerViewAdapter.OnRecyclerItemClickListener,
    SectionNavigationFragment.OnRequestNavigationDataListener,
//    SectionNavigationFragment.OnPackageExpiredListener,
    OnCheckPackageExpiredListener,
    OnRetrySectionListener,
    OnNextSectionListener,
    OnGetNumberOfSectionsListener,
    OnGotoSectionCorrectionListener,
    OnRequestToGoToResultListener,
    OnPaperScoreListener,
    OnIsSectionAnsweredListener {

    private lateinit var paperActivityViewModel: PaperActivityViewModel
//    private val paperFragmentsStack = ArrayList<Fragment>()
//    private var currentFragmentIndex = 0
    private lateinit var pref: SharedPreferences

    private lateinit var checkBox: CheckBox
    private lateinit var tvInstruction: TextView

    private lateinit var tvSubscriptionFormTitle: TextView
    private lateinit var layoutPackagePrice: LinearLayout
    private lateinit var autoCompletePackageType: AutoCompleteTextView
    private lateinit var tvPackagePrice: TextView
    private lateinit var autoCompleteMomoPartner: AutoCompleteTextView
    private lateinit var etMomoNumber: TextInputEditText
    private lateinit var subscriptionFormView: View
    private lateinit var subscriptionFormDialogPositiveBtn: Button

    private lateinit var requestToPayDialogView: View
    private lateinit var tvRequestToPayMessage: TextView
    private lateinit var tvRequestToPaySubject: TextView
    private lateinit var tvRequestToPayPackage: TextView
    private lateinit var tvRequestToPayAmount: TextView

    private lateinit var requestToPayDialog: AlertDialog

    private lateinit var activationSuccessfulDialog: AlertDialog
    private lateinit var activationSuccessfulDialogView: View
    private lateinit var tvPackageActivationSuccessful: TextView

    private lateinit var activationFailedDialog: AlertDialog
    private lateinit var activationFailedDialogView: View

    private var currentSectionFragment: Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paper)
        initRequestToPayDialog()
//        initRequestToPayDialogViews()
        initActivationSuccessfulDialog()
        initActivationFailedDialog()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        setupViewModel()
        setupPackageActivatedObserver()
        displayPaperInstructionDialog()
        gotoSectionNavigationFragment()



    }

    private fun setupViewModel(){
        val bundle = intent.getBundleExtra("paperData")
        val examItemDataModel = bundle!!.getSerializable("paperSerializable") as ExamItemDataModel

        paperActivityViewModel = ViewModelProvider(this)[PaperActivityViewModel::class.java]
        paperActivityViewModel.setExamItemData(examItemDataModel)
        paperActivityViewModel.setSubjectName(bundle.getString("subjectName")!!)

        val paperDataJsonString = getJsonFromAssets(paperActivityViewModel.getExamFileName())
        paperActivityViewModel.initPaperData(paperDataJsonString)
        paperActivityViewModel.setCurrentFragmentIndex(0)


        paperActivityViewModel.setDataBase(GceOLMcqDatabase.getDatabase(this))
        paperActivityViewModel.querySubjectPackageDataTableBySubjectName()

        val customId =
            "${bundle.getString("subjectName")!!} ${paperActivityViewModel.getExamTitle()}"
        paperActivityViewModel.queryStatisticsDataTableByCustomId(customId)

        this.title = paperActivityViewModel.getExamTitle()
    }


    private fun gotoSectionNavigationFragment() {
        this.title = paperActivityViewModel.getExamTitle()
        val sectionNavigationFragment = SectionNavigationFragment.newInstance()
        replaceFragment(sectionNavigationFragment, 0)
    }

    private fun gotoSection(sectionIndex: Int) {
//        paperActivityViewModel.setCurrentSectionIndex(sectionIndex)
        if(currentSectionFragment != null){
            replaceFragment(currentSectionFragment!!, 1)
        }else{
            val sectionFragment =
                SectionFragment.newInstance(
                    sectionIndex,
                    paperActivityViewModel.getSectionData(sectionIndex)
                )
            replaceFragment(sectionFragment, 1)
        }
    }

    private fun gotoResult(sectionResultData: SectionResultData) {
//        this.title = resources.getString(R.string.result)
        paperActivityViewModel.setSectionResultData(sectionResultData)
        val sectionResultFragment = SectionResultFragment.newInstance(
            sectionResultData,
            intent.getBundleExtra("paperData")!!.getString("expiresOn")!!
        )
        replaceFragment(sectionResultFragment, 2)

    }

    private fun gotoSectionCorrection(
        sectionIndex: Int,
        userMarkedAnswersSheetData: UserMarkedAnswersSheetData
    ) {
        paperActivityViewModel.setUserMarkedAnswerSheet(userMarkedAnswersSheetData)
        val sectionCorrectionFragment = CorrectionFragment.newInstance(
            sectionIndex,
            userMarkedAnswersSheetData,
            intent.getBundleExtra("paperData")!!.getString("expiresOn")!!
        )
        replaceFragment(sectionCorrectionFragment, 3)

    }

    private fun replaceFragment(fragment: Fragment, fragmentIndex: Int) {
        paperActivityViewModel.setCurrentFragmentIndex(fragmentIndex)

        val transaction = supportFragmentManager.beginTransaction()

        transaction.apply {
            replace(R.id.sectionNavigationFragmentHolder, fragment)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        title = paperActivityViewModel.getExamTitle()
        when(paperActivityViewModel.getCurrentFragmentIndex()){
            0 -> gotoSectionNavigationFragment()
            1 -> {
                gotoSection(paperActivityViewModel.getCurrentSectionIndex())
            }
            2 -> {gotoResult(paperActivityViewModel.getSectionResultData())}
            3 -> {gotoSectionCorrection(paperActivityViewModel.getCurrentSectionIndex(), paperActivityViewModel.getUserMarkedAnswerSheet())}
        }

    }

    private fun resetCurrentSectionFragment(){
        currentSectionFragment = null
    }

    override fun onRecyclerItemClick(position: Int) {
        resetCurrentSectionFragment()
        paperActivityViewModel.setCurrentSectionIndex(position)

        if (!paperActivityViewModel.checkSubjectPackageExpiry() && !paperActivityViewModel.getIsSectionAnsweredAt(position)
        ) {
            showPackageExpiredDialog()

        } else if (!paperActivityViewModel.getIsSectionAnsweredAt(position)) {
            gotoSection(position)
        } else {
            Toast.makeText(
                this,
                "${paperActivityViewModel.getSectionNumberAt(position)} ${resources.getString(R.string.has_been_answered)}",
                Toast.LENGTH_LONG
            ).show()
        }

    }

    override fun onBackPressed() {


        if (paperActivityViewModel.getCurrentFragmentIndex() == 0) {
            this.finish()
        } else {
            gotoSectionNavigationFragment()
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun getJsonFromAssets(fileName: String): String? {
        lateinit var json: String
        val charset: Charset = Charsets.UTF_8

        try {
            val jsonFile = assets.open(fileName)
            val size = jsonFile.available()
            val buffer = ByteArray(size)

            jsonFile.read(buffer)
            jsonFile.close()
            json = String(buffer, charset)

        } catch (e: IOException) {
//            println("Exception")
            return null
        }
        return json
    }

    override fun onRequestSectionNames(): Array<String>? {

        return paperActivityViewModel.getSectionNames()
    }

    override fun onRequestSectionNameBundleList(): Array<Bundle>? {
        return paperActivityViewModel.getSectionNameBundleList()
    }

    override fun onRequestTotalNumberOfQuestions(): Int {
        return paperActivityViewModel.getTotalNumberOfQuestions()
    }

    override fun onRequestToGoToResult(sectionResultData: SectionResultData) {
        gotoResult(sectionResultData)
    }

    override fun onRetrySection(sectionIndex: Int) {
        resetCurrentSectionFragment()
        gotoSection(sectionIndex)
        paperActivityViewModel.resetSectionScore(sectionIndex)
    }

    override fun onNextSection(sectionIndex: Int) {
        resetCurrentSectionFragment()
        paperActivityViewModel.resetCurrentSectionRetryCount()
        gotoSection(sectionIndex)
    }

    override fun onGetNumberOfSections(): Int {
        return paperActivityViewModel.getNumberOfSections()
    }

    override fun onAllSectionsAnswered(): Boolean {
        return paperActivityViewModel.getUnAnsweredSectionIndexes().isEmpty()
    }

    override fun onGotoSectionCorrection(
        sectionIndex: Int,
        userMarkedAnswersSheetData: UserMarkedAnswersSheetData
    ) {
        gotoSectionCorrection(sectionIndex, userMarkedAnswersSheetData)
    }

    override fun onUpdatePaperScore(sectionIndex: Int, numberOfCorrectAnswers: Int) {
        paperActivityViewModel.updateSectionsScore(sectionIndex, numberOfCorrectAnswers)
    }

    override fun onGetPaperScore(): Int {
        return paperActivityViewModel.getPaperScore()
    }

    override fun onUpdateIsSectionAnswered(sectionIndex: Int) {
        paperActivityViewModel.updateIsSectionsAnswered(sectionIndex)
    }

    override fun onGetSectionsAnswered(): List<Boolean> {
        return paperActivityViewModel.getIsSectionsAnswered()
    }


    override fun onStop() {
        if (paperActivityViewModel.getIsPaperAttempted() && paperActivityViewModel.getAttemptCount() == 1) {
            paperActivityViewModel.setStatisticsDataScores()
            paperActivityViewModel.insertToStatisticsDataTable()

        } else if (paperActivityViewModel.getIsPaperAttempted() && paperActivityViewModel.getAttemptCount() > 1) {
            paperActivityViewModel.updateStatisticsDataScores()
            paperActivityViewModel.updateStatisticsDataTable()
        }
        super.onStop()
    }

    private fun showPackageExpiredDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setMessage(resources.getString(R.string.package_expired_message))
            setPositiveButton(resources.getString(R.string.subscribe)) { _, _ ->
//                on subscribe button clicked, show subscription form dialog
                displaySubscriptionFormDialog()
            }
            setNegativeButton(resources.getString(R.string.cancel)){_, _ ->}
//            setCancelable(false)
        }.create().show()
    }


    override fun onDecrementCurrentSectionRetryCount() {
        paperActivityViewModel.decrementCurrentSectionRetryCount()
    }

    override fun onResetCurrentSectionRetryCount() {
        paperActivityViewModel.resetCurrentSectionRetryCount()
    }

    override fun onCheckPackageExpired(): Boolean {
        return paperActivityViewModel.checkSubjectPackageExpiry()
    }

    override fun onShowPackageExpiredDialog() {
        showPackageExpiredDialog()
    }

    override fun onGetCurrentSectionRetryCount(): LiveData<Int> {
        return paperActivityViewModel.getCurrentSectionRetryCount()
    }

    private fun displayPaperInstructionDialog() {
        pref = getSharedPreferences(resources.getString(R.string.app_name), MODE_PRIVATE)
        val doNotShowThis = pref.getBoolean(SHOW_INSTRUCTION, false)
        if (!doNotShowThis) {
            val editor = pref.edit()
            val instruction = AlertDialog.Builder(this)
            val view = this.layoutInflater.inflate(R.layout.paper_instruction_dialog_lo, null)
            checkBox = view.findViewById(R.id.instructionCheckBox)
            tvInstruction = view.findViewById(R.id.tvPaperInstruction)
            val message: String =
                "${paperActivityViewModel.getExamTitle()} ${resources.getStringArray(R.array.paper_instruction)[0]} ${paperActivityViewModel.getTotalNumberOfQuestions()} " +
                        "${resources.getStringArray(R.array.paper_instruction)[1]} ${paperActivityViewModel.getNumberOfSections()} ${resources.getStringArray(R.array.paper_instruction)[2]} " +
                        "${resources.getStringArray(R.array.paper_instruction)[3]} ${resources.getStringArray(R.array.paper_instruction)[4]} " +
                        "${resources.getStringArray(R.array.paper_instruction)[5]} ${resources.getString(R.string.minimum_percentage)} ${resources.getStringArray(R.array.paper_instruction)[6]}"
            tvInstruction.text = message
            instruction.apply {
                setView(view)
                setPositiveButton("OK") { btnOk, _ ->
                    if (checkBox.isChecked) {
                        editor.apply {
                            putBoolean(SHOW_INSTRUCTION, true)
                        }.apply()
                    }
                    btnOk.dismiss()
                }
            }.create().show()
        }

    }

    private fun initSubscriptionFormViews(){
        subscriptionFormView = layoutInflater.inflate(R.layout.fragment_subcription_form, null)
        tvSubscriptionFormTitle = subscriptionFormView.findViewById(R.id.tvSubscriptionFormTitle)
        tvSubscriptionFormTitle.text = paperActivityViewModel.getSubjectName()
        layoutPackagePrice = subscriptionFormView.findViewById(R.id.layoutPackagePrice)
        autoCompletePackageType = subscriptionFormView.findViewById(R.id.autoCompletePackageType)
        tvPackagePrice = subscriptionFormView.findViewById(R.id.tvPackagePrice)
        autoCompleteMomoPartner = subscriptionFormView.findViewById(R.id.autoCompleteMomoPartner)
        etMomoNumber = subscriptionFormView.findViewById(R.id.etMomoNumber)

    }

    private fun setupSubscriptionFormViewAdapters(){
        autoCompletePackageType.setAdapter(
            ArrayAdapter<String>(
                this,
                R.layout.drop_down_item,
                resources.getStringArray(R.array.package_types)
            )
        )

        autoCompleteMomoPartner.setAdapter(
            ArrayAdapter<String>(
                this,
                R.layout.drop_down_item,
                resources.getStringArray(R.array.momo_partners)
            )
        )
    }

    private fun setupSubscriptionFormViewListeners(){
        autoCompletePackageType.setOnItemClickListener { _, _, packageIndex, _ ->
            paperActivityViewModel.setPackageType(resources.getStringArray(R.array.package_types)[packageIndex])
            layoutPackagePrice.visibility = View.VISIBLE
            tvPackagePrice.text = "${resources.getStringArray(R.array.package_prices)[packageIndex]} FCFA"
            paperActivityViewModel.setPackagePrice(resources.getStringArray(R.array.package_prices)[packageIndex])
            paperActivityViewModel.setPackageDuration(resources.getStringArray(R.array.package_durations)[packageIndex].toInt())
        }

        autoCompleteMomoPartner.setOnItemClickListener { _, _, momoPartnerIndex, _ ->
            Toast.makeText(this, "$momoPartnerIndex", Toast.LENGTH_LONG).show()
            paperActivityViewModel.setMomoPartner(resources.getStringArray(R.array.momo_partners)[momoPartnerIndex])
        }

        etMomoNumber.doOnTextChanged { text, _, _, _ ->
            paperActivityViewModel.setMomoNumber(text.toString())

        }
    }

    private fun setupSubscriptionFormViewObservers(){
        paperActivityViewModel.isSubscriptionFormFilled.observe(this, Observer{
            subscriptionFormDialogPositiveBtn.isEnabled = it
        })
    }

    private fun displaySubscriptionFormDialog() {
        initSubscriptionFormViews()
        setupSubscriptionFormViewAdapters()
        setupSubscriptionFormViewListeners()
        setupSubscriptionFormViewObservers()
        val subscriptionFormDialog = AlertDialog.Builder(this)
        subscriptionFormDialog.apply {
            setView(subscriptionFormView)
            setPositiveButton(resources.getString(R.string.activate)) { _, _ ->
//                display request to pay dialog

                displayRequestToPayDialog()
//                initiate payment in a background thread
                paperActivityViewModel.requestToPay()

            }
            setNegativeButton(resources.getString(R.string.cancel)){p, _ ->
                p.dismiss()
            }
            setCancelable(false)
        }
        val dialog = subscriptionFormDialog.create()
        dialog.show()
        subscriptionFormDialogPositiveBtn = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        subscriptionFormDialogPositiveBtn.isEnabled = false
    }
    private fun initRequestToPayDialogViews(){
        requestToPayDialogView = layoutInflater.inflate(R.layout.fragment_request_to_pay, null)
        tvRequestToPayMessage = requestToPayDialogView.findViewById(R.id.tvRequestToPayMessage)
        tvRequestToPaySubject = requestToPayDialogView.findViewById(R.id.tvRequestToPaySubject)
        tvRequestToPayPackage = requestToPayDialogView.findViewById(R.id.tvRequestToPayPackage)
        tvRequestToPayAmount = requestToPayDialogView.findViewById(R.id.tvRequestToPayAmount)
    }

    private fun setUpRequestToPayDialogViews(){
        if(paperActivityViewModel.getMomoPartner() == resources.getStringArray(R.array.momo_partners)[0]){
            tvRequestToPayMessage.text = resources.getString(R.string.mtn_request_to_pay_message)
        }else{
            tvRequestToPayMessage.text = resources.getString(R.string.orange_request_to_pay_message)
        }
        tvRequestToPayPackage.text = paperActivityViewModel.getPackageType()
        tvRequestToPayAmount.text = "${paperActivityViewModel.getPackagePrice()} FCFA"
    }

    private fun initRequestToPayDialog(){
        requestToPayDialog = AlertDialog.Builder(this).create()
    }

    private fun displayRequestToPayDialog(){
        initRequestToPayDialogViews()
        setUpRequestToPayDialogViews()
        setupTransactionStatusObserver()
        requestToPayDialog = AlertDialog.Builder(this).apply {
            setView(requestToPayDialogView)
            setCancelable(false)
        }.create()
        requestToPayDialog.show()
    }

    private fun dismissRequestToPayDialog(){
        requestToPayDialog.dismiss()
    }

    private fun setupTransactionStatusObserver(){
        paperActivityViewModel.isPaymentSuccessful().observe(this, Observer{
            if(it){
                dismissRequestToPayDialog()
                Toast.makeText(this, resources.getString(R.string.payment_received), Toast.LENGTH_LONG).show()
                paperActivityViewModel.activateSubjectPackage()

            }else{
                showActivationFailedDialog()
            }
        })
    }

    private fun initActivationSuccessfulDialog(){
        activationSuccessfulDialogView = layoutInflater.inflate(R.layout.package_activation_successful_dialog, null)
        tvPackageActivationSuccessful = activationSuccessfulDialogView.findViewById(R.id.tvPackageActivationSuccessful)
        activationSuccessfulDialog = AlertDialog.Builder(this).apply{
            setView(activationSuccessfulDialogView)
            setPositiveButton("OK"){_, _ ->}
        }.create()

    }

    private fun setupPackageActivationSuccessfulViews(){
        tvPackageActivationSuccessful.text = "${paperActivityViewModel.getPackageType()} ${resources.getString(R.string.activated_successfully)}"
    }

    private fun showActivationSuccessfulDialog(){
        setupPackageActivationSuccessfulViews()
        activationSuccessfulDialog.show()

    }

    private fun initActivationFailedDialogView(){
        activationFailedDialogView = layoutInflater.inflate(R.layout.package_activation_failed_dialog, null)
    }

    private fun initActivationFailedDialog(){
        initActivationFailedDialogView()
        activationFailedDialog = AlertDialog.Builder(this).apply{
            setView(activationFailedDialogView)
            setPositiveButton("Ok"){btn, _ ->
                btn.dismiss()
            }
        }.create()

    }

    private fun showActivationFailedDialog(){
        activationFailedDialog.show()
    }


    private fun setupPackageActivatedObserver(){
        paperActivityViewModel.isPackageActivated.observe(this, Observer{
            if(it){
                CoroutineScope(Dispatchers.IO).launch {
//                    paperActivityViewModel.querySubjectPackageDataTableBySubjectName()
                    delay(2000)
                    withContext(Dispatchers.Main){
                        showActivationSuccessfulDialog()
                    }
                }
            }
        })
    }


}

interface OnRequestToGoToResultListener {
    fun onRequestToGoToResult(sectionResultData: SectionResultData)
}

interface OnRetrySectionListener {
    fun onRetrySection(sectionIndex: Int)
    fun onDecrementCurrentSectionRetryCount()
    fun onGetCurrentSectionRetryCount(): LiveData<Int>
}

interface OnNextSectionListener {
    fun onNextSection(sectionIndex: Int)
    fun onResetCurrentSectionRetryCount()

}

interface OnGetNumberOfSectionsListener {
    fun onGetNumberOfSections(): Int
    fun onAllSectionsAnswered(): Boolean
}

interface OnGotoSectionCorrectionListener {
    fun onGotoSectionCorrection(
        sectionIndex: Int,
        userMarkedAnswersSheetData: UserMarkedAnswersSheetData
    )
}

interface OnPaperScoreListener {
    fun onUpdatePaperScore(sectionIndex: Int, numberOfCorrectAnswers: Int)
    fun onGetPaperScore(): Int
}

interface OnIsSectionAnsweredListener {
    fun onUpdateIsSectionAnswered(sectionIndex: Int)
    fun onGetSectionsAnswered(): List<Boolean>
}

interface OnCheckPackageExpiredListener{
    fun onCheckPackageExpired():Boolean
    fun onShowPackageExpiredDialog()
}





