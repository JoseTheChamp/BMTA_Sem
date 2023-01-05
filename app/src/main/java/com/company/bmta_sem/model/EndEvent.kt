package Model

import com.company.bmta_sem.model.Event

class EndEvent(
    override var id: Int,
    override var name: String,
    override var story: String,
    var option: EventOption
) : Event() {

    override fun getAllEventoptions(): List<EventOption> {
        return listOf(option)
    }

    override fun getEventOptionsPossible(hero: Hero): List<Boolean> {
        return listOf(true)
    }
}