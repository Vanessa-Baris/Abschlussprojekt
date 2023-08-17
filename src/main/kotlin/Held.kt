open class Held ( val name: String, var hp: Int) {

    fun healing(amount: Int) {
        println("$name wird um $amount HP geheilt.")
        hp += amount
    }

    fun power(factor: Double) {
        println("$name wird um ${factor * 100}% stärker.")
    }


    val actions: MutableList<(Gegner) -> Unit> = mutableListOf()
    var isBlocked: Boolean = false

    fun addAction(action: (Gegner) -> Unit) {
        actions.add(action)
    }

    open fun attack(target: Gegner) {
        println("$name greift ${target.name} an.")
        useAction(target)
    }

    //Von Chat GPT Anregung geholt und auf meine Bedürfnisse umgewandelt, da ich nicht wusste, wie ich blocken soll:
    fun useAction(target: Gegner) {
        if (actions.isNotEmpty()) {
            val action = actions[0]
            if (isBlocked) {
                println("$name ist geschützt und blockt die nächste Aktion.")
                isBlocked = false
            } else {
                action(target)
            }
            actions.removeAt(0)
        }
    }

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

    open fun useVitamin() {
        val beutel = Beutel()
        if (beutel.canUseVitamin()) {
            println("$name verwendet ein Vitamin und wird dauerhaft um 10% stärker.")
            power(0.1)
            beutel.hasUsedVitamin = true
        } else {
            println("Das Vitamin kann nicht mehr verwendet werden.")
        }
    }

    open fun isDead(): Boolean {
        return hp <= 0
    }

    open fun randomAttack(target: Gegner , beutel: Beutel) {
        println("$name führt eine normale Attacke aus.")
        val damage = 15
        target.hp -= damage
        println("$name fügt ${target.name} $damage Schaden zu.")
    }



}
