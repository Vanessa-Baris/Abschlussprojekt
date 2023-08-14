class Oreade(var name1: String, var hp1: Int) : Held(name1, hp1) {

    var blossomMagicUsed = false
    var clairvoyanceUsed: Boolean = false
    var darkThornsUsed = false
    var treeTrunkLongThrowUsed = false


    fun attack(target: Gegner) {
        println("Wähle deinen Angriff aus, tippe dazu eine Zahl von 1-3 ein.")
        var attackChoice = readln().toIntOrNull()

        when (attackChoice) {
            1 -> blossomMagic(50..75, target)
            2 -> clairvoyance(0, target)
            3 -> darkThorns(30..44, target)
            4 -> treeTrunkLongThrow(40..53, target)
            else -> {
                println("Ungültige Auswahl.")
            }
        }
    }

    //Von IJ verbessert, mein Code war vorher ohne: target -> (aber macht schon Sinn)
    init {
        addAction { target -> blossomMagic(50..75, target) }
        addAction { target -> clairvoyance(0, target) }
        addAction { target -> darkThorns(30..44, target) }
        addAction { target -> treeTrunkLongThrow(40..53, target) }
    }

    fun blossomMagic(damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        blossomMagicUsed = true
        println("$name1 wirft mit Blüten um sich herum und trifft ${target.name}. Es richtet $damage Schaden an.")
    }

    fun clairvoyance(damage: Int, target: Gegner) {
        if (!clairvoyanceUsed) {
            target.hp -= damage
            clairvoyanceUsed = true
            println("$name verwendet Hellsicht und verursacht $damage Schaden an ${target.name}.")
            isBlocked = true
        } else {
            println("$name kann Hellsicht in dieser Runde nicht erneut verwenden.")
        }
    }

    fun darkThorns(damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        darkThornsUsed = true
        println("$name1 wirft dunkle Dornen in die Runde und trifft ${target.name} und verursacht $damage Schaden.")
    }

    fun treeTrunkLongThrow(damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        treeTrunkLongThrowUsed = true
        println("$name1 wirft einen Baumstamm und trifft ${target.name}. Es verursacht $damage Schaden.")
    }

    override fun randomAttack(target: Gegner) {
        val attackChoice = (1..4).random()
        when (attackChoice) {
            1 -> blossomMagic(50..75, target)
            2 -> clairvoyance(0, target)
            3 -> darkThorns(30..44, target)
            4 -> treeTrunkLongThrow(40..53, target)
            else -> println("Ungültige Auswahl.")
        }
    }
    }










