package com.company.bmta_sem.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.company.bmta_sem.R
import com.company.bmta_sem.model.GameProvider


class RowHeroHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var btnRow : Button

    init {
        btnRow = view.findViewById(R.id.row)
    }

    fun setLogData(prompt: String,position: Int,context: Context) {
        btnRow?.text = prompt
        btnRow?.setOnClickListener{
            println("BUTTON PRESS")
            GameProvider.game?.currentHero = GameProvider.game?.heroes!![position]
            context.startActivity(Intent(context, MainMenuActivity::class.java))
        }
    }
}