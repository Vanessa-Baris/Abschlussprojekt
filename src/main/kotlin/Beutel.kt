class Beutel {
    var hasUsedVitamin: Boolean = false // guckt, ob ein Vitamin verwendet wurde
    var hasUsedThisRound: Boolean = false // guckt, ob in dieser Runde bereits etwas aus dem Beutel verwendet wurde
    var remainingHealingPotions: Int = 3 // Anzahl der verbleibenden Heiltränke

    // Überprüft, ob noch Heiltränke verwendet werden können
    fun canUseHealing(): Boolean {
        return remainingHealingPotions > 0
    }

    // Überprüft, ob in dieser Runde noch etwas aus dem Beutel verwendet werden kann
    fun canUseThisRound(): Boolean {
        return !hasUsedThisRound
    }

    // Markiert den Beutel als in dieser Runde verwendet
    fun markAsUsedThisRound() {
        hasUsedThisRound = true
    }

    // Überprüft, ob ein Vitamin verwendet werden kann
    fun canUseVitamin(): Boolean {
        return !hasUsedVitamin
    }
}
