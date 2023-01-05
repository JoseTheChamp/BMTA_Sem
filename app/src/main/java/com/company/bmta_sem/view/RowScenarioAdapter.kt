package com.company.bmta_sem.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.company.bmta_sem.R

class RowScenarioAdapter(val prompts: List<String>) : RecyclerView.Adapter<RowScenarioHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowScenarioHolder {
        return RowScenarioHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.hero_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RowScenarioHolder, position: Int) {
        holder.setLogData(prompts[position], position)
    }

    override fun getItemCount(): Int {
        return prompts.size
    }
}