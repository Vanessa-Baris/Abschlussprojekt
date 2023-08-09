class Push() {
    var damage = (30..33).random()
    var used: Boolean = false

    fun pushUseAbility(target: Gegner) {
        if (used) {
            target.hp -= damage
            println("Push: Es richtet $damage Schaden an.")
            used = true
        } else {
            println("Push wurde bereits in dieser Runde verwendet!")
        }
    }

    fun resetAbility() {
        used = false
    }}