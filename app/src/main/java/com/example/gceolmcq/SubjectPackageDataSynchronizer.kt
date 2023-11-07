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
                            MCQConstants.HOURS,
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

                if(it.size < packageDataList.size){
                    val subjectNamesInPackageDataList = getSubjectNamesFromPackageDataList(packageDataList)
                    subjectNamesInPackageDataList.forEachIndexed { index, subjectNameInPackageDataList ->
                        if(!it.contains(subjectNameInPackageDataList)){
                            packageDataList.removeAt(index)
                        }
                    }
                }
            }

            return packageDataList
        }

        private fun getSubjectNamesFromPackageDataList(subjectPackages: List<SubjectPackageData>):List<String>{
            val subjectNames = ArrayList<String>()
            subjectPackages.forEach {
                subjectNames.add(it.subjectName!!)
            }
            return subjectNames
        }


    }
}