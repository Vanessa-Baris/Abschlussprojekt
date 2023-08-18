class Vampir(var name2: String, var hp2: Int) : Held(name2, hp2) {

    // Variablen, um den Einsatz der Attacken zu verfolgen
    var camoUsed = false
    var biteUsed = false
    var manipulationUsed = false
    var scratchUsed = false

    // Überschreibt die attack-Methode der Elternklasse Held
    override fun attack(target: Gegner) {
        println("Wähle deinen Angriff aus, tippe dazu eine Zahl von 1-4 ein.")
        var attackChoice = readLine()?.toIntOrNull()

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

    // Initialisierung der addAction für den Helden Vampir Attacken hinzufügt
    init {
        addAction { target -> bite(44..50, target) }
        addAction { target -> camoCape(5..10, target) }
        addAction { target -> manipulation(30..44, target) }
        addAction { target -> scratch(20..35, target) }
    }

//Funktion bite
    fun bite(damage: IntRange, target: Gegner) {
        val damageAmount = damage.random()
        target.hp -= damageAmount
        biteUsed = true
        println("$name2 beißt ${target.name} in den Hals und verursacht $damageAmount Schaden.")
}


    //Funktion Camo Cape
   fun camoCape(damage: IntRange, target: Gegner) {
        val damageAmount = damage.random()
        target.hp -= damageAmount
        camoUsed = true
        println("$name2 wirft sich den Tarnumhang über und zwickt ${target.name}. Dabei entsteht $damageAmount Schaden.")
    }

    //Funktion Manipulation
    fun manipulation(damage: IntRange, target: Gegner) {
        val damageAmount = damage.random()
        target.hp -= damageAmount
        manipulationUsed = true
        println("$name2 manipuliert ${target.name} und verursacht $damageAmount Schaden.")
    }

    //Funktion Scratch
    fun scratch(damage: IntRange, target: Gegner) {
        val damageAmount = damage.random()
        target.hp -= damageAmount
        scratchUsed = true
        println("$name2 kratzt ${target.name} und verursacht $damageAmount Schaden.")
    }

    //Überschreiben Elternklasse randomAttack mit Vampir Angriff, wenn man nicht ausgewählt hat in Main
     override fun randomAttack(target: Gegner) {
        val attackChoice = (1..4).random()
        when (attackChoice) {
            1 -> bite(44..50, target)
            2 -> camoCape(5..10, target)
            3 -> manipulation(30..44, target)
            4 -> scratch(20..35, target)
            else -> println("Ungültige Auswahl.")
        }
    }
}

