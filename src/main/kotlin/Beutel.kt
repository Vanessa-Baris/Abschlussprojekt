class Beutel {
    var hasUsedThisRound: Boolean = false
    var hasUsedHealing: Boolean = false
    var hasUsedVitamin: Boolean = false

    fun resetRound() {
        hasUsedThisRound = false
        hasUsedHealing = false
        hasUsedVitamin = false
    }

    fun canUseHealing(): Boolean {
        return !hasUsedHealing
    }

    fun canUseVitamin(): Boolean {
        return !hasUsedVitamin
    }

    fun canUseThisRound(): Boolean {
        return !hasUsedThisRound
    }

    fun markAsUsedThisRound() {
        hasUsedThisRound = true
    }

    fun useBag() {
        if (canUseThisRound()) {
            println("Der Beutel wurde genutzt.")
            markAsUsedThisRound()
        } else {
            println("Der Beutel wurde bereits in dieser Runde genutzt.")
        }
    }

    fun useHealing(held: Held) {
        if (canUseThisRound() && canUseHealing()) {
            println("${held.name} verwendet einen Heiltrank und stellt HP um die Hälfte wieder her.")
            held.healing(held.hp / 2)
            markAsUsedThisRound()
            hasUsedHealing = true
        } else {
            println("Der Heiltrank kann in dieser Runde nicht mehr verwendet werden.")
        }
    }

    fun useVitamin(held: Held) {
        if (canUseVitamin()) {
            println("${held.name} verwendet ein Vitamin und wird dauerhaft um 10% stärker.")
            held.power(0.1)
            hasUsedVitamin = true
        } else {
            println("Das Vitamin kann nicht mehr verwendet werden.")
        }
    }
}
