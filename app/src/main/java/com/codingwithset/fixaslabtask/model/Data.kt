package com.codingwithset.fixaslabtask.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Data(
    @PrimaryKey
    val name: String,
    val price_usd: String,
    val percent_change_1h: String,
    val symbol: String
)
