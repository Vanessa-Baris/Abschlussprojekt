class Zombie(var name3: String, var hp3: Int) : Held(name3, hp3) {

    // Variablen, um den Einsatz der Attacken zu verfolgen
    var pushUsed = false
    var huntUsed = false
    var nibbleUsed = false
    var staggeringAwayUsed = false

    // Überschreibt die attack-Methode der Elternklasse Held
    override fun attack(target: Gegner) {
        println("Wähle deinen Angriff aus, tippe dazu eine Zahl von 1-4 ein.")
        var attackChoice = readLine()?.toIntOrNull()

        when (attackChoice) {
            1 -> push(30..33, target)
            2 -> hunt(40..50, target)
            3 -> nibble(20..30, target)
            4 -> staggeringAway(0, target)
            else -> {
                println("Ungültige Auswahl.")
            }
        }
    }

    // Initialisierung der addAction für den Helden Zombie Attacken hinzufügt
    init {
        addAction { target -> push(30..33, target) }
        addAction { target -> hunt(40..50, target) }
        addAction { target -> nibble(20..30, target) }
        addAction { target -> staggeringAway(0, target) }
    }

    //push Funktion
    fun push(damage: IntRange, target: Gegner) {
        val damageAmount = damage.random()
        target.hp -= damageAmount
        pushUsed = true
        println("$name3 schlägt ${target.name} und verursacht $damageAmount Schaden.")
    }

    //hunt Funktion
    fun hunt(damage: IntRange, target: Gegner) {
        val damageAmount = damage.random()
        target.hp -= damageAmount
        huntUsed = true
        println("$name3 jagt ${target.name} hinterher und verursacht $damageAmount Schaden.")
    }

    //nibble Funktion
    fun nibble(damage: IntRange, target: Gegner) {
        val damageAmount = damage.random()
        target.hp -= damageAmount
        nibbleUsed = true
        println("$name3 knabbert ${target.name} mit großen Genuss an und verursacht $damageAmount Schaden.")
    }

    //Staggering Away Funktion
    fun staggeringAway(damage: Int, target: Gegner) {
        staggeringAwayUsed = true
        println("$name3 wird das alles zu viel. $name3 torkelt weg um zu fliehen und setzt eine Runde aus.")
    }

    //Überschreiben Elternklasse randomAttack mit Zombie Angriff, wenn man nicht ausgewählt hat in Main
    override fun randomAttack(target: Gegner) {
        val attackChoice = (1..4).random()
        when (attackChoice) {
            1 -> push(30..33, target)
            2 -> hunt(40..50, target)
            3 -> nibble(20..30, target)
            4 -> staggeringAway(0, target)
            else -> println("Ungültige Auswahl.")
        }
    }

    }

