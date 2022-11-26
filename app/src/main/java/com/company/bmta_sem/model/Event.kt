package com.company.bmta_sem.model

import Model.EventOption
import Model.Hero

abstract class Event() : java.io.Serializable {
    open var id : Int = -1
    open var name : String = "Event"
    open var story : String = "Pribeh."

    abstract fun run(hero: Hero) : Int
    abstract fun getAllEventoptions() : List<EventOption>
    abstract fun getEventOptionsPossible(hero: Hero) : List<Boolean>







}