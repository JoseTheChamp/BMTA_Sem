package Model

class EndEvent (override var id : Int, override var name : String, override var story : String, var option : EventOption): Event() {
    override fun run(hero: Hero): Int {
        println("------------------------------")
        println(id.toString() + name + " - " + story)
        readln()
        return option.targetId
    }

    override fun getAllEventoptions(): List<EventOption> {
        return listOf(option)
    }

    override fun getEventOptionsPossible(hero: Hero): List<Boolean> {
        return listOf(true)
    }
}