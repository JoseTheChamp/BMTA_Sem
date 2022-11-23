package Model

data class EventOption (var targetId : Int, var name : String, var hint : String) {
    lateinit var requirements: List<StatValue>
    constructor(targetId: Int,name: String,hint: String,requirements: List<StatValue>) : this(targetId,name,hint){
        this.requirements = requirements
    }
    fun isDoable(hero: Hero) : Boolean{
        var cislo = 0
        for (stat in requirements){
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
        if (cislo != 0){
            println("Fail")
            return false
        }
        println("Uspech")
        return true
    }
}