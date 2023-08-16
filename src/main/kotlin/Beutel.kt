class Beutel {
    var hasUsedVitamin: Boolean = false 
    var hasUsedThisRound: Boolean = false
    var remainingHealingPotions: Int = 3

    fun resetRound() {
        hasUsedThisRound = false
        remainingHealingPotions = 3
    }

    fun canUseHealing(): Boolean {
        return remainingHealingPotions > 0
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

    //Von IJ:
    fun canUseVitamin(): Boolean {
        return !hasUsedVitamin

    }
}

   



