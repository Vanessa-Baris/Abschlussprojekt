open class Held (open val name: String, open var hp: Int) {

    var hasActedThisRound: Boolean = false
    var hasUsedBeutelThisRound: Boolean = false

    fun resetRound() {
        hasActedThisRound = false
        hasUsedBeutelThisRound = false
    }

    open fun canActThisRound(): Boolean {
        return hasActedThisRound
    }

    open fun markBeutelAsUsedThisRound() {
        hasUsedBeutelThisRound = true
    }

    open fun markAsActedThisRound() {
        hasActedThisRound = true
    }

    open fun canUseBeutelThisRound(): Boolean {
        return hasUsedBeutelThisRound && hasActedThisRound
    }

    open fun performAction(target: Gegner) {
        if (canActThisRound()) {
            println("$name kämpft gegen ${target.name}.")
            markAsActedThisRound()
        } else {
            println("$name hat bereits in dieser Runde gekämpft.")
        }
    }

    fun healing(amount: Int) {
        println("$name wird um $amount HP geheilt.")
        hp += amount
    }

    fun useHealing(amount: Int) {
        println("$name verwendet einen Heiltrank und stellt HP um die Hälfte der GesamtHP wieder her.")
        healing(amount)
    }

    fun power(factor: Double) {
        println("$name wird um ${factor * 100}% stärker.")
    }


    val actions: MutableList<(Gegner) -> Unit> = mutableListOf()
    var isBlocked: Boolean = false

    fun addAction(action: (Gegner) -> Unit) {
        actions.add(action)
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

    open fun useHealing() {
        val beutel = Beutel()
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

    open fun randomAttack(target: Gegner) {
        println("$name führt eine normale Attacke aus.")
        val damage = 15
        target.hp -= damage
        println("$name fügt ${target.name} $damage Schaden zu.")
    }




    fun summonGolem(golem: Golem) {
        println("$name ruft den Golem zur Unterstützung!")
        golem.attackOnce(this)
    }
}
