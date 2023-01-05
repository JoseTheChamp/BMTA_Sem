package com.company.bmta_sem.view

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.company.bmta_sem.R
import com.company.bmta_sem.model.GameProvider

class RowScenarioHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var btnRow: Button

    init {
        btnRow = view.findViewById(R.id.row)
    }

    fun setLogData(prompt: String, position: Int) {
        btnRow?.text = prompt
        btnRow?.setOnClickListener {
            println("BUTTON PRESS")
            GameProvider.game?.StartScenario(btnRow.context, position)
        }
    }
}