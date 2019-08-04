package com.example.criminalintent

import java.util.*

class Crime(var title: String, var isSolved: Boolean) {
    val id: UUID = UUID.randomUUID()
    var date: Date = Date();
}