class Vampir(var name2: String , hp2: Int): Held(name2 , hp2) {

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

    var vampir = Vampir("Barnabas", 70)

    init {
        addAction(bite(44..50, Gegner()))
        addAction(camoCape(5..10, Gegner()))
        addAction(manipulation(30..44, Gegner()))
        addAction(scratch(20..35, Gegner()))
    }

    private fun bite(damage: IntRange, target: Gegner) {
        var bite = Bite()
        var target.hp -= bite.damage
        bite.biteUseAbility(target)
        println("$name2 beißt ${target.name} in den Hals und verursacht $damage Schaden.")
    }

    private fun camoCape(damage: IntRange, target: Gegner) {
        var camoCape = CamoCape()
        var target.hp -= camoCape.damage
        camoCape.camoUseAbility(target)
        println("$name2 wirft sich den Tarnumhang über und zwickt ${target.name}. Dabei entsteht $damage Schaden.")
    }

    private fun manipulation(damage: IntRange, target: Gegner) {
        var manipulation = Manipulation()
        var target.hp -= manipulation.damage
        manipulation.manipulationUseAbility(target)
        println("$name2 manipuliert ${target.name} und verursacht $damage Schaden.")
    }

    private fun scratch(damage: IntRange, target: Gegner) {
        var scratch = Scratch()
        var target.hp -= scratch.damage
        scratch.scratchUseAbility(target)
        println("$name2 kratzt ${target.name} und verursacht $damage Schaden.")
    }
}

