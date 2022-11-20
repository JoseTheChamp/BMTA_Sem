package com.company.bmta_sem.view

import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.company.bmta_sem.R
import java.text.FieldPosition

class RowHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var btnRow : Button
    private var cislo : Int = 0

    init {
        btnRow = view.findViewById(R.id.row)
        btnRow.setOnClickListener{
            //TODO SOMETHIN i guess
        }
    }

    fun setLogData(prompt: String,position: Int) {
        btnRow?.text = prompt
        cislo = position
    }
}