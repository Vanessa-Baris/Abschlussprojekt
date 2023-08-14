class Vampir(var name2: String, var hp2: Int) : Held(name2, hp2) {

    var camoUsed = false
    var biteUsed = false
    var manipulationUsed = false
    var scratchUsed = false
     fun attack(target: Gegner) {
        println("Wähle deinen Angriff aus, tippe dazu eine Zahl von 1-3 ein.")
        var attackChoice = readln().toIntOrNull()

        when (attackChoice) {
            1 -> bite(44..50, target)
            2 -> camoCape(5..10, target)
            3 -> manipulation(30..44, target)
            4 -> scratch(20..35, target)
            else -> {
                println("Ungültige Auswahl.")
            }
        }
    }
    init {
        addAction { target -> bite(44..50, target) }
        addAction { target -> camoCape(5..10, target) }
        addAction { target -> manipulation(30..44, target) }
        addAction { target -> scratch(20..35, target) }
    }


    fun bite(damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        biteUsed = true
        println("$name2 beißt ${target.name} in den Hals und verursacht $damage Schaden.")
    }

   fun camoCape(damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        camoUsed = true
        println("$name2 wirft sich den Tarnumhang über und zwickt ${target.name}. Dabei entsteht $damage Schaden.")
    }

    fun manipulation(damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        manipulationUsed = true
        println("$name2 manipuliert ${target.name} und verursacht $damage Schaden.")
    }

    fun scratch(damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        scratchUsed = true
        println("$name2 kratzt ${target.name} und verursacht $damage Schaden.")
    }
}

