class Beutel() {
    var hasUsedThisRound: Boolean = false

    fun resetRound() {
        hasUsedThisRound = false
}

    fun canUseThisRound(): Boolean {
    return hasUsedThisRound
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