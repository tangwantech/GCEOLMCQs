package com.example.gceolmcq

import com.example.gceolmcq.datamodels.SubjectPackageData

class SubjectPackageActivator {
    companion object{
        fun activateTrialPackageForAllSubjectsAvailable(availableSubjects: List<String>?): List<SubjectPackageData>{
            val activationExpiryDates =
                ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
                    MCQConstants.MINUTES,
                    MCQConstants.TRIAL_DURATION
                )

            val packageDataList = ArrayList<SubjectPackageData>()
            availableSubjects?.forEachIndexed { subjectIndex, subject ->

                packageDataList.add(
                    SubjectPackageData(
                        subjectIndex,
                        subject,
                        "TRIAL",
                        activationExpiryDates.activatedOn,
                        activationExpiryDates.expiresOn,
                        isPackageActive = true
                    )
                )

            }
            return packageDataList
        }

        fun activateSubjectPackage(tempSubjectName: String, tempSubjectIndex: Int, packageType: String, packageDuration: Int): SubjectPackageData {
            val activationExpiryDates =
                ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
                    MCQConstants.MINUTES,
                    packageDuration
                )
            val subjectPackageData = SubjectPackageData().apply {
                subjectIndex = tempSubjectIndex
                subjectName = tempSubjectName
                packageName = packageType
                activatedOn = activationExpiryDates.activatedOn
                expiresOn = activationExpiryDates.expiresOn
            }

            return subjectPackageData
        }

    }

}