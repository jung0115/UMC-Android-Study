package com.bicontest.umc_week8.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bicontest.umc_week8.db_entity.MemoDataEntity

@Dao
interface MemoDataDao {
    @Query("SELECT * FROM MemoDataEntity") // 전체 데이터
    fun getAllMemoData(): MutableList<MemoDataEntity>

    @Insert
    fun insertMemoData(category: MemoDataEntity) // 데이터 추가

    @Delete
    fun deleteMemoData(category: MemoDataEntity) // 데이터 삭제
}