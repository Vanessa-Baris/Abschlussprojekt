open class Held ( val name: String, var hp: Int) {

    //Funktion heilen mit Rechnung:
    fun healing(amount: Int) {
        hp += amount
    }

    //Funktion zur Stärkung des Helden:
    fun power(factor: Double) {
        factor * 100
    }

    // Liste von Aktionen, die der Held ausführen kann
    val actions: MutableList<(Gegner) -> Unit> = mutableListOf()

    // Funktion zum Hinzufügen einer Aktion zur Liste
    fun addAction(action: (Gegner) -> Unit) {
        actions.add(action)
    }

    // Standard-Angriffsfunktion des Helden
    open fun attack(target: Gegner) {
        println("$name greift ${target.name} an.")
    }



    //Funktion zum verwenden des Heiltranks:
    open fun useHealing(beutel: Beutel) {
        if (beutel.canUseThisRound() && beutel.canUseHealing()) {
            println("$name verwendet einen Heiltrank und stellt HP um die Hälfte der GesamtHP wieder her.")
            healing(hp / 2)
            beutel.markAsUsedThisRound()
            beutel.remainingHealingPotions--
        } else {
            println("Der Heiltrank kann in dieser Runde nicht mehr verwendet werden.")
        }
    }

    //Funktion zum verwenden eines Vitamins
    open fun useVitamin(beutel: Beutel) {
        if (beutel.canUseVitamin()) {
            println("$name verwendet ein Vitamin und wird dauerhaft um 10% stärker.")
            power(0.1)
            beutel.hasUsedVitamin = true
        } else {
            println("Das Vitamin kann nicht mehr verwendet werden.")
        }
    }

//Überprüft ob Held tot ist
    open fun isDead(): Boolean {
        return hp <= 0
    }

    //Funktion für zufälligen Angriff, offene und vererbt weiter an Held
    open fun randomAttack(target: Gegner) {
        val damage = 0
        target.hp -= damage
    }



}
