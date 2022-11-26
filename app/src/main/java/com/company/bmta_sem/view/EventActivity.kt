package com.company.bmta_sem.view

import Model.Event
import Model.EventOption
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.company.bmta_sem.viewModel.Game

abstract class EventActivity(open var event: Event) : AppCompatActivity(){
    public abstract fun setNameStory()
    public abstract fun setContent()
    public abstract fun setOptions()
    public fun createoptionButton(option: EventOption, possible: Boolean,game: Game): LinearLayout?{
        var ll = LinearLayout(this)
        ll.setOrientation(LinearLayout.VERTICAL);

        var button = Button(this)
        button.text = option.name
        button.setOnClickListener{
            game.StartEvent(this,option.targetId)
            //TODO create activity
        }
        button.isEnabled = possible
        ll.addView(button)

        //TODO requirements

        var text = TextView(this)
        text.text = option.hint
        ll.addView(text)

        return ll
    }
}