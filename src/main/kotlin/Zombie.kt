class Zombie(val name3: String , var hp3: Int): Held(name3 , hp3) {
    init {
        addAction(push(33 , Gegner()))
        addAction(hunt(40 , Gegner()))
        addAction(nibble(20 , Gegner()))
        addAction(staggeringAway(0 , Gegner()))
    }

    private fun push(damage: Int , target: Gegner) {
        println("$name3 schlägt ${target.name} und verursacht $damage Schaden.")
    }

    private fun hunt(damage: Int , target: Gegner) {
        println("$name3 jagt ${target.name} hinterher und verursacht $damage Schaden.")
    }

    private fun nibble(damage: Int , target: Gegner) {
        println("$name3 knabbert ${target.name} mit großen Genuss an und verursacht $damage Schaden.")
    }

    private fun staggeringAway(damage: Int , target: Gegner) {
        println("$name3 wird das alles zu viel. $name3 torkelt weg um zu fliehen und setzt eine Runde aus.")
    }

    private fun addAction(action: Unit) {}

}