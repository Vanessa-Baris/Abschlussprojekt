class Beutel {
    var hasUsedThisRound: Boolean = false
    var hasUsedHealing: Boolean = false
    var hasUsedVitamin: Boolean = false

    var remainingHealingPotions: Int = 3

    fun resetRound() {
        hasUsedThisRound = false
        remainingHealingPotions = 3
        hasUsedVitamin = false
    }

    fun canUseHealing(): Boolean {
        return remainingHealingPotions > 0
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
}


