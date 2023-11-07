package com.example.gceolmcq

import com.example.gceolmcq.datamodels.SubjectPackageData

class SubjectsPackagesBuilder {
    fun build(availableSubjects: List<String>?): List<SubjectPackageData>{
        val packageDataList = ArrayList<SubjectPackageData>()
        availableSubjects?.forEachIndexed { subjectIndex, subject ->

            packageDataList.add(
                SubjectPackageData(
                    subjectIndex,
                    subject,
                    MCQConstants.NA,
                    MCQConstants.NA,
                    MCQConstants.NA,
                    isPackageActive = false
                )
            )

        }
        return packageDataList

    }
}