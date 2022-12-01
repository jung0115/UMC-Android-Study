package com.bicontest.umc_week8.db_entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MemoDataEntity (
    @PrimaryKey(autoGenerate = true)
    val memo_uid: Int,          // id = key

    @ColumnInfo
    val memo_text: String       // 메모 내용
)