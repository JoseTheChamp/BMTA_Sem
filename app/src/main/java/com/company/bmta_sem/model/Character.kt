package Model

abstract class Character () {
    open var name : String = "Entity"
    open var description : String = "Description"
    open var health : Double = 100.0
    open var attack : Double = 1.0
    open var armor : Double = 0.0

    fun isDead() : Boolean{
        return (health < 0.00001)
    }

    open fun attack (enemy: Character) : Boolean {
        var attackMin = attack*0.25
        var realAttack = attack - enemy.armor
        if (attackMin > realAttack) realAttack = attackMin
        enemy.health -= realAttack

        if (enemy.isDead()) return true
        return false
    }

}