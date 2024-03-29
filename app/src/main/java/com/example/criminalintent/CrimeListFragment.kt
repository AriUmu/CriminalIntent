package com.example.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class CrimeListFragment : Fragment() {

    private lateinit var crimeRecyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_crime_list, container, false)
        crimeRecyclerView = view.findViewById(R.id.crime_recycler_view)
        crimeRecyclerView.layoutManager = LinearLayoutManager(activity)

        updateUI()
        return view
    }

    private fun updateUI() {
        var crimeLab = CrimeLab
        var crimes = crimeLab.getCrimes()
        var adapter = CrimeAdapter(crimes)
        crimeRecyclerView.adapter = adapter
    }

    class CrimeHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_crime, parent, false)) {

        private var textView: TextView
        private var dateView: TextView
        private lateinit var crime: Crime;

        init {
            textView = itemView.findViewById(R.id.crime_title)
            dateView = itemView.findViewById(R.id.crime_date)
            dateView.setOnClickListener { v -> Toast.makeText(v.context, "clicked", Toast.LENGTH_SHORT).show()}
        }

        fun bind(crime: Crime) {
            this.crime = crime
            textView.setText(crime.title)
            dateView.setText(crime.date.toString())
        }
    }


    class CrimeAdapter(crimes: List<Crime>) : Adapter<CrimeHolder>() {

        private var crimes: List<Crime> = crimes

        override fun getItemCount(): Int {
            return crimes.size
        }

        override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
            holder.bind(crimes.get(position))
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return CrimeHolder(layoutInflater, parent)
        }
    }
}