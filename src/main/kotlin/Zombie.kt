class Zombie(val name3: String , var hp3: Int): Held(name3 , hp3) {
    var zombie = Zombie("Olivia" , 60)
    init {
        addAction(push(30..33 , Gegner()))
        addAction(hunt(40..50 , Gegner()))
        addAction(nibble(20..30 , Gegner()))
        addAction(staggeringAway(0 , Gegner()))
    }

    private fun push(damage: IntRange, target: Gegner) {
        //anpassen und klassen für jede attacke
        var push = Push()
        var target.hp -= push.damage
        //var round noch einfügen
        println("$name3 schlägt ${target.name} und verursacht $damage Schaden.")
    }

    private fun hunt(damage: IntRange, target: Gegner) {
        var hunt = Hunt()
            var target.hp -= hunt.damage
        println("$name3 jagt ${target.name} hinterher und verursacht $damage Schaden.")
    }

    private fun nibble(damage: IntRange, target: Gegner) {
        var nibble = Nibble()
        var target.hp -= nibble.damage
        println("$name3 knabbert ${target.name} mit großen Genuss an und verursacht $damage Schaden.")
    }

    private fun staggeringAway(damage: Int , target: Gegner) {
        println("$name3 wird das alles zu viel. $name3 torkelt weg um zu fliehen und setzt eine Runde aus.")
    } //brauche ich hier eine Klasse wegen berechnen?

    private fun addAction(action: Unit) {}

}