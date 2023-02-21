package com.example.gceolmcq.roomDB

import androidx.room.*
import com.example.gceolmcq.datamodels.StatisticsData
import com.example.gceolmcq.datamodels.SubjectPackageData

@Dao
interface StatisticsDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(statisticsData: StatisticsData)

    @Query("DELETE FROM mcq_statistics_data_table")
    fun deleteAll()

    @Query("SELECT * FROM mcq_statistics_data_table WHERE custom_id LIKE :customId")
    fun findByCustomId(customId: String): StatisticsData

    @Update()
    fun update(statisticsData: StatisticsData)


}