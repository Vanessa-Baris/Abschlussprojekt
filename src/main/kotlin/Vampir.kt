class Vampir(var name2: String , hp2: Int): Held(name2 , hp2) {
    //welche Klasse?
    var camoUsed = false
    var biteUsed = false
    var manipulationUsed = false
    var scratchUsed = false
    override fun attack(target: Gegner) {
        println("Wähle deinen Angriff aus, tippe dazu eine Zahl von 1-3 ein.")
        var attackChoice = readln().toIntOrNull()

        when (attackChoice) {
            1 -> bite(44..50, Gegner())
            2 -> camoCape(5..10, Gegner())
            3 -> manipulation(30..44, Gegner())
            4 -> scratch(20..35, Gegner())
            else -> {
                println("Ungültige Auswahl.")
            }
        }
        useAction1(target)
    }
    init {
        addAction(bite(44..50, Gegner()))
        addAction(camoCape(5..10, Gegner()))
        addAction(manipulation(30..44, Gegner()))
        addAction(scratch(20..35, Gegner()))
    }


    private fun bite(damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        biteUsed = true
        println("$name2 beißt ${target.name} in den Hals und verursacht $damage Schaden.")
    }

    private fun camoCape(damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        camoUsed = true
        //println("Camo Cape: Es richtet $damage Schaden an.") Was ist besser? Das oder das:
        println("$name2 wirft sich den Tarnumhang über und zwickt ${target.name}. Dabei entsteht $damage Schaden.")
    }

    private fun manipulation(damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        manipulationUsed = true
        println("$name2 manipuliert ${target.name} und verursacht $damage Schaden.")
    }

    private fun scratch(damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        scratchUsed = true
        println("$name2 kratzt ${target.name} und verursacht $damage Schaden.")
    }
}

