package com.androiddevs.runningappyt.repositories

import com.androiddevs.runningappyt.db.Run
import com.androiddevs.runningappyt.db.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDao
) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunsSortedByDate() = runDao.getALlRunsSortedByDate()

    fun getALlRunsSortedByDistance() = runDao.getALlRunsSortedByDistance()

    fun getALlRunsSortedByTimeInMillis() = runDao.getALlRunsSortedByTimeInMillis()

    fun getALlRunsSortedByAvgSpeed() = runDao.getALlRunsSortedByAvgSpeed()

    fun getALlRunsSortedByCaloriesBurned() = runDao.getALlRunsSortedByCaloriesBurned()

    fun getTotalAvgSpeed() = runDao.getTotalAvgSpeed()

    fun getTotalDistance() = runDao.getTotalDistance()

    fun getTotalCaloriesBurned() = runDao.getTotalCaloriesBurned()

    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()

}