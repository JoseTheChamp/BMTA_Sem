package Model

import com.company.bmta_sem.model.Event

class ChallengeEvent(
    override var id: Int,
    override var name: String,
    override var story: String,
    var optionPassed: EventOption,
    var optionFailed: EventOption,
    var stat: StatValue
) : Event() {

    fun logika(hero: Hero): Boolean {
        var failed = false
        when (stat.stat) {
            Stat.STRENGTH -> if (hero.strength < stat.value) failed = true
            Stat.ARMOR -> if (hero.armor < stat.value) failed = true
            Stat.CHARISMA -> if (hero.charisma < stat.value) failed = true
            Stat.ATTACK -> if (hero.attack < stat.value) failed = true
            Stat.CONSTITUTION -> if (hero.constitution < stat.value) failed = true
            Stat.HEALTH -> if (hero.health < stat.value) failed = true
            Stat.DEXTERITY -> if (hero.dexterity < stat.value) failed = true
            Stat.INTELIGENCE -> if (hero.inteligence < stat.value) failed = true
            Stat.WISDOM -> if (hero.wisdom < stat.value) failed = true
        }
        if (failed) return false
        return true
    }

    override fun getAllEventoptions(): List<EventOption> {
        return listOf(optionPassed, optionFailed)
    }

    override fun getEventOptionsPossible(hero: Hero): List<Boolean> {
        if (logika(hero)) return listOf(true, false)
        return listOf(false, true)
    }
}