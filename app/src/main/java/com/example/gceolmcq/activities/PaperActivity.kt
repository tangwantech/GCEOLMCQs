package com.example.gceolmcq.activities

//import com.example.gceolmcq.datamodels.SectionAnsweredScoreData
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.gceolmcq.R
import com.example.gceolmcq.adapters.SectionNavigationRecyclerViewAdapter
import com.example.gceolmcq.datamodels.ExamItemDataModel
import com.example.gceolmcq.datamodels.SectionResultData
import com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData
import com.example.gceolmcq.fragments.*
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.example.gceolmcq.viewmodels.PaperActivityViewModel
import java.io.IOException
import java.nio.charset.Charset
private const val SHOW_INSTRUCTION = "showInstruction"

class PaperActivity : AppCompatActivity(),
    SectionNavigationRecyclerViewAdapter.OnRecyclerItemClickListener,
    SectionNavigationFragment.OnRequestNavigationDataListener,
    OnCheckPackageExpiredListener,
    OnRetrySectionListener,
    OnNextSectionListener,
    OnGetNumberOfSectionsListener,
    OnGotoSectionCorrectionListener,
    OnRequestToGoToResultListener,
    OnPaperScoreListener,
    OnIsSectionAnsweredListener {

    private lateinit var paperActivityViewModel: PaperActivityViewModel
    private lateinit var pref: SharedPreferences

    private lateinit var checkBox: CheckBox
    private lateinit var tvInstruction: TextView

    private var currentSectionFragment: Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paper)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setupViewModel()
        displayPaperInstructionDialog()
        loadFragment()



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
        paperActivityViewModel.getSubjectPackageDataFromLocalDbWhereSubjectName()

        val customId =
            "${bundle.getString("subjectName")!!} ${paperActivityViewModel.getExamTitle()}"
//        paperActivityViewModel.queryStatisticsDataTableByCustomId(customId)

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
//        loadFragment()

    }

    private fun loadFragment(){
        when(paperActivityViewModel.getCurrentFragmentIndex()){
            0 -> gotoSectionNavigationFragment()
            1 -> {
                gotoSection(paperActivityViewModel.getCurrentSectionIndex())
            }
            2 -> {
                gotoResult(paperActivityViewModel.getSectionResultData())
            }
            3 -> {
                gotoSectionCorrection(paperActivityViewModel.getCurrentSectionIndex(), paperActivityViewModel.getUserMarkedAnswerSheet())
            }
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

    override fun onRequestSectionsScores(): ArrayList<Int> {
        return paperActivityViewModel.getSectionScores()
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


//    override fun onStop() {
//
//        super.onStop()
//    }

    private fun showPackageExpiredDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setMessage(resources.getString(R.string.package_expired_message))
            setPositiveButton(resources.getString(R.string.ok)) { _, _ ->
                gotoSectionNavigationFragment()
            }
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





