package com.example.criminalintent

import java.util.*

data class Crime(val id: UUID = UUID.randomUUID(), var title: String, var date: Date, var isSolved: Boolean) {
    init {
        date = Date();
    }
}