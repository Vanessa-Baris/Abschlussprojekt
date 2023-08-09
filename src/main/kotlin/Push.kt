class Push() {
    var damage = (30..33).random()
    var used: Boolean = false

    fun pushUseAbility(target: Gegner) {
        if (used) {
            target.hp -= damage
            println("Blossom Magic: Es richtet $damage Schaden an.")
            used = true
        } else {
            println("Blossom Magic wurde bereits in dieser Runde verwendet!")
        }
    }

    fun resetAbility() {
        used = false
    }}