package com.company.bmta_sem.view

import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.company.bmta_sem.R
import com.company.bmta_sem.viewModel.Game
import com.company.bmta_sem.viewModel.GameProvider
import java.text.FieldPosition

class RowHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var btnRow : Button

    init {
        btnRow = view.findViewById(R.id.row)
    }

    fun setLogData(prompt: String,position: Int) {
        btnRow?.text = prompt
        btnRow?.setOnClickListener{
            GameProvider.game.StartScenario(position)
        }
    }
}