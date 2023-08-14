class Zombie(var name3: String, var hp3: Int) : Held(name3, hp3) {

    var pushUsed = false
    var huntUsed = false
    var nibbleUsed = false
    var staggeringAwayUsed = false


    fun attack(target: Gegner) {
        println("Wähle deinen Angriff aus, tippe dazu eine Zahl von 1-3 ein.")
        var attackChoice = readln().toIntOrNull()

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

    init {
        addAction { target -> push(30..33, target) }
        addAction { target -> hunt(40..50, target) }
        addAction { target -> nibble(20..30, target) }
        addAction { target -> staggeringAway(0, target) }
    }

    fun push(damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        pushUsed = true
        println("$name3 schlägt ${target.name} und verursacht $damage Schaden.")
    }

    fun hunt(damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        huntUsed = true
        println("$name3 jagt ${target.name} hinterher und verursacht $damage Schaden.")
    }

    fun nibble(damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        nibbleUsed = true
        println("$name3 knabbert ${target.name} mit großen Genuss an und verursacht $damage Schaden.")
    }

    fun staggeringAway(damage: Int, target: Gegner) {
        target.hp -= damage
        staggeringAwayUsed = true
        println("$name3 wird das alles zu viel. $name3 torkelt weg um zu fliehen und setzt eine Runde aus.")
    }

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

