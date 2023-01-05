package Model

data class EventOption(var targetId: Int, var name: String, var hint: String) :
    java.io.Serializable {
    var stat: StatValue? = null

    constructor(targetId: Int, name: String, hint: String, requirement: StatValue) : this(
        targetId,
        name,
        hint
    ) {
        this.stat = requirement
    }

    fun isDoable(hero: Hero): Boolean {
        var failed = false
        if (stat?.stat == null) throw Exception("Stat was not inicialied but was used. (isDoable in Event Option)")
        when (stat!!.stat) {
            Stat.STRENGTH -> if (hero.strength < stat!!.value) failed = true
            Stat.ARMOR -> if (hero.armor < stat!!.value) failed = true
            Stat.CHARISMA -> if (hero.charisma < stat!!.value) failed = true
            Stat.ATTACK -> if (hero.attack < stat!!.value) failed = true
            Stat.CONSTITUTION -> if (hero.constitution < stat!!.value) failed = true
            Stat.HEALTH -> if (hero.health < stat!!.value) failed = true
            Stat.DEXTERITY -> if (hero.dexterity < stat!!.value) failed = true
            Stat.INTELIGENCE -> if (hero.inteligence < stat!!.value) failed = true
            Stat.WISDOM -> if (hero.wisdom < stat!!.value) failed = true
        }
        if (failed) return false
        return true
    }
}