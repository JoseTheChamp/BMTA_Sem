package com.company.bmta_sem.view

import com.company.bmta_sem.model.Event
import Model.EventOption
import Model.Hero
import Model.Stat
import android.app.ActionBar.LayoutParams
import android.graphics.Color
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.updateLayoutParams
import com.company.bmta_sem.R
import com.company.bmta_sem.databinding.ActivityStoryEventBinding
import com.company.bmta_sem.viewModel.Game

abstract class EventActivity() : AppCompatActivity() {
    lateinit var game: Game
    lateinit var hero: Hero

    public abstract fun setNameStory()
    public abstract fun setContent()
    public abstract fun setOptions()
    public fun createoptionButton(
        option: EventOption,
        possible: Boolean,
        game: Game,
        count: Int
    ): LinearLayout? {
        var ll = LinearLayout(this)
        var params = LinearLayout.LayoutParams(100, 400, 1f)
        ll.layoutParams = params
        ll.orientation = LinearLayout.VERTICAL


        var button = Button(this)
        button.text = option.name

        button.setOnClickListener {
            println("BUTTON PRESSED targetId: " + option.targetId.toString())
            game.StartEvent(this, option.targetId)
            //TODO create activity
        }
        button.isEnabled = possible
        ll.addView(button)

        //TODO requirements

        if (option.stat != null) {
            var reqText = TextView(this)
            reqText.text =
                "Required: " + option.stat!!.stat.toString() + " " + option.stat!!.value.toString()
            if (possible) {
                reqText.setTextColor(Color.parseColor("#159939"))
            } else {
                reqText.setTextColor(Color.parseColor("#99141d"))
            }
            ll.addView(reqText)
        }


        var text = TextView(this)
        text.text = option.hint
        ll.addView(text)

        return ll
    }
}