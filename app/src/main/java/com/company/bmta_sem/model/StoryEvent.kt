package Model

import com.company.bmta_sem.model.Event
import java.lang.Exception

class StoryEvent (override var id : Int, override var name : String, override var story : String, var options : List<EventOption>): Event() {

    fun vypis() : Int{
        println("------------------------------")
        println(id.toString() + name + " - " + story)
        println("Tvoje moznosti")
        var i = 1
        for (eo in options){
            println(i.toString() + ") " + eo.name + " - " + eo.hint + "       " + eo.targetId);
            i++
        }
        return readln().toInt()
    }
    override fun run(hero: Hero): Int {
        var index = vypis()
        if (index > options.count() || index <= 0){
            throw Exception("Tato moznost nebyla na vyber.")
        }
        return options[index-1].targetId
    }

    override fun getAllEventoptions(): List<EventOption> {
        return options
    }

    override fun getEventOptionsPossible(hero: Hero): List<Boolean> {
        var bools = arrayListOf<Boolean>()
        for (option in options){
            if (option.stat == null) {
                bools.add(true)
            }else{
                bools.add(option.isDoable(hero))
            }
        }
        return bools
    }
}