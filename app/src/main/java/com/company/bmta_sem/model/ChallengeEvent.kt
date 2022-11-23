package Model

class ChallengeEvent (override var id : Int, override var name : String, override var story : String, var optionPassed : EventOption, var optionFailed : EventOption, var stats : List<StatValue>): Event() {

    fun vypis(hero: Hero) : EventOption{
        println(name + " - " + story)
        if (logika(hero)){
            println("Fail")
            return optionFailed
        }
        println("Uspech")
        return optionPassed
    }

    fun logika(hero: Hero) : Boolean{
        var cislo = 0
        for (stat in stats){
            when (stat.stat) {
                Stat.STRENGTH -> if (hero.strength < stat.value) cislo++
                Stat.ARMOR -> if (hero.armor < stat.value) cislo++
                Stat.CHARISMA -> if (hero.charisma < stat.value) cislo++
                Stat.ATTACK -> if (hero.attack < stat.value) cislo++
                Stat.CONSTITUTION -> if (hero.constitution < stat.value) cislo++
                Stat.HEALTH -> if (hero.health < stat.value) cislo++
                Stat.DEXTERITY -> if (hero.dexterity < stat.value) cislo++
                Stat.INTELIGENCE -> if (hero.inteligence < stat.value) cislo++
                Stat.WISDOM -> if (hero.wisdom < stat.value) cislo++
            }
        }
        if (cislo != 0) return false
        return true
    }

    override fun run(hero: Hero): Int {
        var option = vypis(hero)
        readln()
        return option.targetId
    }

    override fun getAllEventoptions(): List<EventOption> {
        return listOf(optionPassed,optionFailed)
    }

    override fun getEventOptionsPossible(hero: Hero): List<Boolean> {
        if (logika(hero)) return listOf(true,false)
        return listOf(false,true)
    }
}