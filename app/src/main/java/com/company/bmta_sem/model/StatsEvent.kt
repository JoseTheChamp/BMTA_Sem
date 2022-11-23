package Model

import java.lang.Exception

class StatsEvent (override var id : Int, override var name : String, override var story : String, var option : EventOption, var stats : List<StatValue>): Event() {
    fun vypis(hero: Hero){
        println(name + " - " + story)
        for (stat in stats){
            when (stat.stat) {
                Stat.STRENGTH -> hero.strength += stat.value
                Stat.ARMOR -> hero.armor += stat.value
                Stat.CHARISMA -> hero.charisma += stat.value
                Stat.ATTACK -> hero.attack += stat.value
                Stat.CONSTITUTION -> hero.constitution += stat.value
                Stat.HEALTH -> hero.health += stat.value
                Stat.DEXTERITY -> hero.dexterity += stat.value
                Stat.INTELIGENCE -> hero.inteligence += stat.value
                Stat.WISDOM -> hero.wisdom += stat.value
            }
            println(stat.stat.toString() + " " + stat.value.toString() + " na ")
        }
    }
    override fun run(hero: Hero): Int {
        vypis(hero)
        readln()
        return option.targetId
    }

    override fun getAllEventoptions(): List<EventOption> {
        return listOf<EventOption>(option)
    }

    override fun getEventOptionsPossible(hero: Hero): List<Boolean> {
        return listOf(option.isDoable(hero))
    }

}