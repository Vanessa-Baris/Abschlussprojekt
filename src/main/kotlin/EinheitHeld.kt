abstract class EinheitHeld(open val name: String, open var hp: Int) {

    abstract fun attack(target: Gegner)
    abstract fun Gegner(): Gegner
}
