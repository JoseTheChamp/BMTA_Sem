package Model

class Hero (override var name: String,override var description: String,override var health: Double,override var attack: Double, override var armor: Double) : Character() {
    var strength : Double = 1.0
    var dexterity : Double = 1.0
    var constitution : Double = 1.0
    var wisdom : Double = 1.0
    var inteligence : Double = 1.0
    var charisma : Double = 1.0


}