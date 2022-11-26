package Model

import com.company.bmta_sem.model.Event

class StatsEvent (override var id : Int, override var name : String, override var story : String, var option : EventOption, var stats : List<StatValue>): Event() {
    fun execute(hero: Hero){
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
        }
    }

    override fun run(hero: Hero): Int {
        TODO("Not yet implemented")
    }

    override fun getAllEventoptions(): List<EventOption> {
        return listOf<EventOption>(option)
    }

    override fun getEventOptionsPossible(hero: Hero): List<Boolean> {
        return listOf(true)
    }

}