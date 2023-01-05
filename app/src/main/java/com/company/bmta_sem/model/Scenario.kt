package Model

import com.company.bmta_sem.model.Event

class Scenario(var name: String, var events: List<Event>) {
    lateinit var hero: Hero

    constructor(name: String, events: List<Event>, hero: Hero) : this(name, events) {
        this.hero = hero
    }
}