package com.example.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment

class CrimeFragment : Fragment() {
    lateinit var crime: Crime
    lateinit var titleField: EditText
    lateinit var button: Button
    lateinit var checkBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime("First title", false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)
        titleField = view.findViewById(R.id.crime_title)
        titleField.addTextChangedListener(
            onTextChanged = { charSequence: CharSequence?, i: Int, i1: Int, i2: Int ->
                crime.title = charSequence.toString()
            })

        button = view.findViewById(R.id.crime_date)
        button.setText(crime.date.toString())
        button.setEnabled(false)

        checkBox = view.findViewById(R.id.crime_solved)
        checkBox.setOnCheckedChangeListener({ compoundButton: CompoundButton, b: Boolean ->
            crime.isSolved = b;
        })

        return view
    }


}

