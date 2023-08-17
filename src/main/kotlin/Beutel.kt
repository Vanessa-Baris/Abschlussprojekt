class Beutel {
    var hasUsedVitamin: Boolean = false 
    var hasUsedThisRound: Boolean = false
    var remainingHealingPotions: Int = 3


    fun canUseHealing(): Boolean {
        return remainingHealingPotions > 0
    }

    fun canUseThisRound(): Boolean {
        return !hasUsedThisRound
    }

    fun markAsUsedThisRound() {
        hasUsedThisRound = true
    }



    //Von IJ:
    fun canUseVitamin(): Boolean {
        return !hasUsedVitamin

    }
}

   



