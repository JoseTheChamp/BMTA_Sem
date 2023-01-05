package com.company.bmta_sem.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.company.bmta_sem.R

class RowHeroAdapter(val prompts: List<String>) : RecyclerView.Adapter<RowHeroHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHeroHolder {
        return RowHeroHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.hero_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RowHeroHolder, position: Int) {
        realOnBindViewHolder(holder, position)
    }

    var context: Context? = null

    fun realOnBindViewHolder(holder: RowHeroHolder, position: Int) {
        holder.setLogData(prompts[position], position, context!!)
    }

    override fun getItemCount(): Int {
        return prompts.size
    }
}