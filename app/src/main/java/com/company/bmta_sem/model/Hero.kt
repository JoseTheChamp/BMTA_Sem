package Model

class Hero (override var name: String,override var description: String,override var health: Double,override var attack: Double, override var armor: Double) : Character() {
    var strength : Double = 1.0
    var dexterity : Double = 1.0
    var constitution : Double = 1.0
    var wisdom : Double = 1.0
    var inteligence : Double = 1.0
    var charisma : Double = 1.0
constructor(name: String,description: String,health: Double,attack: Double,armor: Double,
            strength: Double,wisdom: Double,inteligence: Double,
            charisma: Double,constitution: Double,dexterity: Double) : this(name,description,health,attack,armor){
                this.strength = strength
                this.charisma = charisma
                this.wisdom = wisdom
                this.constitution = constitution
                this.dexterity = dexterity
                this.inteligence = inteligence
            }
}