package Model

import com.company.bmta_sem.model.Event
import com.company.bmta_sem.model.GameProvider

class FightEvent(
    override var id: Int,
    override var name: String,
    override var story: String,
    var enemy: Enemy,
    var optionPassed: EventOption,
    var optionFailed: EventOption
) : Event() {

    fun vypis(hero: Hero): EventOption {
        println("------------------------------")
        println(id.toString() + name + " - " + story)
        println("Stoji před tebou " + enemy.name)
        // TODO - boj
        if (boj(hero)) {
            println("Won")
            return optionPassed
        }
        println("Lost")
        return optionFailed
    }

    fun boj(hero: Hero): Boolean {
        var hero = GameProvider.game?.currentHero!!
        var damageToHero: Double
        var damageToEnemy: Double
        while (!enemy.isDead() && !hero.isDead()) {
            damageToHero = enemy.attack - hero.armor
            if (damageToHero < 0.2) damageToHero = 0.2
            damageToEnemy = hero.attack - enemy.armor
            if (damageToEnemy < 0.2) damageToEnemy = 0.2
            hero.health = hero.health - damageToHero
            enemy.health = enemy.health - damageToEnemy
            println("BOJ - kolo")
            println(hero.health)
        }
        //GameProvider.game!!.currentHero.health = hero.health
        if (enemy.isDead()) return true;
        return false;
    }

    override fun getAllEventoptions(): List<EventOption> {
        return listOf(optionPassed, optionFailed)
    }

    override fun getEventOptionsPossible(hero: Hero): List<Boolean> {
        if (boj(hero)) return listOf(true, false)
        return listOf(false, true)
    }
}