package com.example.gceolmcq.datamodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson

@Entity(tableName = "mcq_statistics_data_table")
data class StatisticsData(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "custom_id")
    val customId: String?,
    @ColumnInfo(name = "number_of_questions")
    val numberOfQuestions: Int?,
    @ColumnInfo(name = "attempts_count")
    var attemptsCount: Int?,
    @ColumnInfo(name = "scores")
    var scores: List<Score>?

): java.io.Serializable

data class Score(val score: Int): java.io.Serializable

class ScoresTypeConverter {
    @TypeConverter
    fun arrayListToJson(value: List<Score>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToArrayList(value: String) = Gson().fromJson(value, Array<Score>::class.java).toList()
}
