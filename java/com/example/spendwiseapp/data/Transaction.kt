package com.example.spendwiseapp.data

import android.os.Parcelable
@Parcelize
class Transaction {
    val id: String,
    val title: String,
    val amount: Double,
    val category: String,
    val type: Type,
    val date: Long

) : Parcelable {
    enum class Type {
        INCOME,
        EXPENSE
    }
}