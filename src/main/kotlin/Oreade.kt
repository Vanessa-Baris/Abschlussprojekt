class Oreade(var name1: String, var hp1: Int) : Held(name1, hp1) {

    // Variablen, um den Einsatz der Attacken zu verfolgen
    var blossomMagicUsed = false
    var clairvoyanceUsed: Boolean = false
    var darkThornsUsed = false
    var treeTrunkLongThrowUsed = false

    // Überschreibt die attack-Methode der Elternklasse Held
    override fun attack(target: Gegner) {
        println("Wähle deinen Angriff aus, tippe dazu eine Zahl von 1-4 ein.")
        var attackChoice = readLine()?.toIntOrNull()

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
    // Initialisierung der addAction für den Helden Oreade Attacken hinzufügt
    //Von IJ verbessert, mein Code war vorher ohne: target -> (aber macht schon Sinn)
    init {
        addAction { target -> blossomMagic(50..75, target) }
        addAction { target -> clairvoyance(0, target) }
        addAction { target -> darkThorns(30..44, target) }
        addAction { target -> treeTrunkLongThrow(40..53, target) }
    }
//Blossom Magic Funktion
    fun blossomMagic(damage: IntRange, target: Gegner) {
    val damageAmount = damage.random()
    target.hp -= damageAmount
    blossomMagicUsed = true
        println("$name1 wirft mit Blüten um sich herum und trifft ${target.name}. Es richtet $damageAmount Schaden an.")
    }

    //Clairvoyance Funktion
    fun clairvoyance(damage: Int, target: Gegner) {
        val damageAmount = damage
            target.hp -= damageAmount
            clairvoyanceUsed = true
            println("$name verwendet Hellsicht und verursacht $damage Schaden an ${target.name}.")
    }

    //Funktion Dark Thorns
    fun darkThorns(damage: IntRange, target: Gegner) {
        val damageAmount = damage.random()
        target.hp -= damageAmount
        darkThornsUsed = true
        println("$name1 wirft dunkle Dornen in die Runde und trifft ${target.name} und verursacht $damage Schaden.")
    }

    //Funktion Tree trunk long throw
    fun treeTrunkLongThrow(damage: IntRange, target: Gegner) {
        val damageAmount = damage.random()
        target.hp -= damageAmount
        treeTrunkLongThrowUsed = true
        println("$name1 wirft einen Baumstamm und trifft ${target.name}. Es verursacht $damageAmount Schaden.")
    }

    //Überschreiben Elternklasse randomAttack mit Oreade Angriff, wenn man nicht ausgewählt hat in Main
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










