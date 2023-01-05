package Model

class Enemy(
    override var name: String, override var description: String,
    override var health: Double, override var attack: Double, override var armor: Double
) : Character() {

}