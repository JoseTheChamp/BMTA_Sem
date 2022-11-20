package com.company.bmta_sem.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.company.bmta_sem.R

class LogAdapter (val prompts : List<String>) : RecyclerView.Adapter<RowHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        return RowHolder(LayoutInflater.from(parent.context).inflate(R.layout.hero_row, parent, false))
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.setLogData(prompts[position],position)
    }

    override fun getItemCount(): Int {
        return prompts.size
    }
}