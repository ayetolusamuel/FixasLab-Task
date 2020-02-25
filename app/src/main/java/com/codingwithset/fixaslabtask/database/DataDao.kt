package com.codingwithset.fixaslabtask.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codingwithset.fixaslabtask.model.Data

/*
handle action on data for cache<room>
 */
@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upSert(data: List<Data>)

    @Query("SELECT * from data")
    fun getAllData(): LiveData<List<Data>>

}