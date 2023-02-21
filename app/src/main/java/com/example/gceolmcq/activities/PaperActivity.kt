package com.example.gceolmcq.activities

//import com.example.gceolmcq.datamodels.SectionAnsweredScoreData
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.R
import com.example.gceolmcq.adapters.SectionNavigationRecyclerViewAdapter
import com.example.gceolmcq.datamodels.ExamItemDataModel
import com.example.gceolmcq.datamodels.SectionResultData
import com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData
import com.example.gceolmcq.fragments.CorrectionFragment
import com.example.gceolmcq.fragments.SectionFragment
import com.example.gceolmcq.fragments.SectionNavigationFragment
import com.example.gceolmcq.fragments.SectionResultFragment
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.example.gceolmcq.viewmodels.PaperActivityViewModel
import java.io.IOException
import java.nio.charset.Charset

class PaperActivity : AppCompatActivity(),
    SectionNavigationRecyclerViewAdapter.OnRecyclerItemClickListener,
    SectionNavigationFragment.OnRequestNavigationDataListener,
    SectionNavigationFragment.OnPackageExpiredListener,
    OnRetrySectionListener,
    OnNextSectionListener,
    OnGetNumberOfSectionsListener,
    OnGotoSectionCorrectionListener,
    OnRequestToGoToResultListener,
    OnPaperScoreListener,
    OnIsSectionAnsweredListener {

    private lateinit var paperActivityViewModel: PaperActivityViewModel

    private val paperFragmentsStack = ArrayList<Fragment>()
    private lateinit var pref: SharedPreferences
    private val DO_NOT_SHOW_THIS = "DO_NOT_SHOW_THIS"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paper)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val bundle = intent.getBundleExtra("paperData")
        val examItemDataModel = bundle!!.getSerializable("paperSerializable") as ExamItemDataModel

        paperActivityViewModel = ViewModelProvider(this)[PaperActivityViewModel::class.java]
        paperActivityViewModel.setExamItemData(examItemDataModel)

        val paperDataJsonString = getJsonFromAssets(paperActivityViewModel.getExamFileName())
        paperActivityViewModel.initPaperData(paperDataJsonString)

        this.title = paperActivityViewModel.getExamTitle()

        paperActivityViewModel.setDataBase(GceOLMcqDatabase.getDatabase(this))
        val customId =
            "${bundle.getString("subjectName")!!} ${paperActivityViewModel.getExamTitle()}"
        paperActivityViewModel.queryStatisticsDataTableByCustomId(customId)


        pref = getSharedPreferences(resources.getString(R.string.app_name), MODE_PRIVATE)
        val doNotShowThis = pref.getBoolean(DO_NOT_SHOW_THIS, false)
        if (!doNotShowThis) {
            displayPaperInstructionDialog()
        }

        gotoSectionNavigationFragment()




    }

    private fun gotoSectionNavigationFragment() {
        val sectionNavigationFragment = SectionNavigationFragment.newInstance()

        replaceFragment(sectionNavigationFragment, 0)
    }

    private fun gotoSection(sectionIndex: Int) {
        val sectionFragment =
            SectionFragment.newInstance(
                sectionIndex,
                paperActivityViewModel.getSectionData(sectionIndex)
            )
        replaceFragment(sectionFragment, 1)

    }

    private fun gotoResult(sectionResultData: SectionResultData) {
        this.title = "Result"
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

        val sectionCorrectionFragment = CorrectionFragment.newInstance(
            sectionIndex,
            userMarkedAnswersSheetData,
            intent.getBundleExtra("paperData")!!.getString("expiresOn")!!
        )
        replaceFragment(sectionCorrectionFragment, 3)

    }

    private fun replaceFragment(fragment: Fragment, fragmentIndex: Int) {

        if (!paperFragmentsStack.contains(fragment)) {
            paperFragmentsStack.add(fragment)

        }

        val transaction = supportFragmentManager.beginTransaction()

        transaction.apply {
            replace(R.id.sectionNavigationFragmentHolder, fragment)
            addToBackStack(fragmentIndex.toString())
            commit()
        }
        paperActivityViewModel.setCurrentViewIndex(fragmentIndex)
    }

    override fun onResume() {
        super.onResume()
        title = paperActivityViewModel.getExamTitle()
//        checkPackageExpiry()

    }

    override fun onRecyclerItemClick(position: Int) {
        if (!ActivationExpiryDatesGenerator().checkExpiry(
                intent.getBundleExtra("paperData")!!.getString("expiresOn")!!
            ) && !paperActivityViewModel.getIsSectionAnsweredAt(position)
        ) {
            showAlertDialog()

        } else if (!paperActivityViewModel.getIsSectionAnsweredAt(position)) {
            gotoSection(position)
        } else {
            Toast.makeText(
                this,
                "${paperActivityViewModel.getSectionNumberAt(position)} has been answered",
                Toast.LENGTH_LONG
            ).show()
        }

    }

    override fun onBackPressed() {
        if (paperActivityViewModel.getCurrentViewIndex() == 0) {
            this.finish()
        } else {
            replaceFragment(paperFragmentsStack.first(), 0)
            this.title = paperActivityViewModel.getExamTitle()
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
            println("Exception")
            return null
        }
        return json
    }

    override fun onRequestSectionNames(): Array<String>? {

        return paperActivityViewModel.getSectionNames()
    }

    override fun onRequestTotalNumberOfQuestions(): Int {
        return paperActivityViewModel.getTotalNumberOfQuestions()
    }

    override fun onRequestToGoToResult(sectionResultData: SectionResultData) {
        gotoResult(sectionResultData)
    }

    override fun onRetrySection(sectionIndex: Int) {
        gotoSection(sectionIndex)
        paperActivityViewModel.resetSectionScore(sectionIndex)
    }

    override fun onNextSection(sectionIndex: Int) {
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
        super.onStop()
        if (paperActivityViewModel.getIsPaperAttempted() && paperActivityViewModel.getAttemptCount() == 1) {
            paperActivityViewModel.setStatisticsDataScores()
            paperActivityViewModel.insertToStatisticsDataTable()

        } else if (paperActivityViewModel.getIsPaperAttempted() && paperActivityViewModel.getAttemptCount() > 1) {
            paperActivityViewModel.updateStatisticsDataScores()
            paperActivityViewModel.updateStatisticsDataTable()
        }
    }

    private fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setMessage(resources.getString(R.string.package_expired_message))
            setPositiveButton("Ok") { _, _ ->
                exitActivity()
            }
            setCancelable(false)
        }.create().show()
    }

    private fun exitActivity() {
//
        this.finish()
    }

    override fun onPackageExpired() {
        showAlertDialog()
    }

    override fun onDecrementCurrentSectionRetryCount() {
        paperActivityViewModel.decrementCurrentSectionRetryCount()
    }

    override fun onResetCurrentSectionRetryCount() {
        paperActivityViewModel.resetCurrentSectionRetryCount()
    }

    override fun onGetCurrentSectionRetryCount(): LiveData<Int> {
        return paperActivityViewModel.getCurrentSectionRetryCount()
    }

    private fun displayPaperInstructionDialog() {

        val editor = pref.edit()
        val instruction = AlertDialog.Builder(this)
        val view = this.layoutInflater.inflate(R.layout.paper_instruction_dialog_lo, null)
        val checkBox: CheckBox = view.findViewById(R.id.instructionCheckBox)
        val tvInstruction: TextView = view.findViewById(R.id.tvPaperInstruction)
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
                        putBoolean(DO_NOT_SHOW_THIS, true)
                    }.apply()
                }
                btnOk.dismiss()
            }
        }.create().show()
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





