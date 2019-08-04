package com.example.criminalintent

object CrimeLab {
    val allCrimes = arrayListOf<Crime>()

    fun getCrimes() : List<Crime> {
        for (i in 1..20) {
            val bool = i % 2 != 0
            val crime = Crime("Crime number " + i, bool)
            allCrimes.add(crime)
        }
        return allCrimes
    }
}