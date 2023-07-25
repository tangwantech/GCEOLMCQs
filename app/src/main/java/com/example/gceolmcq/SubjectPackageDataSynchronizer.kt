package com.example.gceolmcq

import com.example.gceolmcq.datamodels.SubjectPackageData

class SubjectPackageDataSynchronizer {
    companion object{
        fun syncSubjectPackageList(
            packageDataList: ArrayList<SubjectPackageData>,
            liveSubjectsAvailable: List<String>?
//        expiryDataList: ArrayList<String>
        ): List<SubjectPackageData> {
            liveSubjectsAvailable?.let{
                if (it.size > packageDataList.size) {
                    val activationExpiryDates =
                        ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
                            MCQConstants.MINUTES,
                            MCQConstants.TRIAL_DURATION
                        )
                    for (index in packageDataList.size until it.size) {

                        val subjectPackageData = SubjectPackageData(
                            index,
                            it[index],
                            "TRIAL",
                            activationExpiryDates.activatedOn,
                            activationExpiryDates.expiresOn
                        )

                        packageDataList.add(subjectPackageData)
//                expiryDataList.add(subjectPackageData.expiresOn!!)
                    }

                }
            }

            return packageDataList
        }


    }
}