package com.company.bmta_sem.viewModel

import Model.Event
import Model.Hero
import Model.Scenario
import Model.JsonConverter
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.company.bmta_sem.view.HeroesGalleryActivity
import com.company.bmta_sem.view.StoryEventActivity

class Game(
    dataJson: String = ""
) : ViewModel() {
    var scenarios : List<Scenario> = listOf()
    var heroes : List<Hero> = listOf()
    lateinit var currentScenario : Scenario
    lateinit var currentHero : Hero

    init {
        val jsonConverter = JsonConverter(dataJson)
        scenarios = jsonConverter.getScenarios()
        heroes = jsonConverter.getHeroes()
    }

    fun StartScenario(context: Context,index: Int){
        println("AAAAAAAAAAAAAA - spust " + index.toString())
        println(scenarios[index].name)
        currentScenario = scenarios[index]
        var intent = Intent(context, StoryEventActivity::class.java)
        //budnle event via lower comment
        context.startActivity(intent)
    }
    fun StartEvent(context: Context,targetId : Int){
        for (event in currentScenario.events){
            if (event.id == targetId) {
                //when type of event
                var intent = Intent(context, StoryEventActivity::class.java)
                //budnle event via lower comment
                context.startActivity(intent)
            }
        }
        throw Exception("Event id does not exist: " + targetId.toString())
    }

    fun toasti(context: Context){
        val toast: Toast = Toast.makeText(context, "Pokussssss", Toast.LENGTH_LONG)
        var intent = Intent(context, HeroesGalleryActivity::class.java)
        context.startActivity(intent)
        toast.show()
    }

/*

Bundle bundle = new Bundle();
bundle.putSerializable("value", all_thumbs);
intent.putExtras(bundle);
And in SomeClass Activity get it as:

Intent intent = this.getIntent();
Bundle bundle = intent.getExtras();

List<Thumbnail> thumbs=
               (List<Thumbnail>)bundle.getSerializable("value");


 */
}