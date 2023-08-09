class Hunt() {
    var damage = (40..50).random()
    var used: Boolean = false

    fun huntUseAbility(target: Gegner) {
        if (used) {
            target.hp -= damage
            println("Hunt: Es richtet $damage Schaden an.")
            used = true
        } else {
            println("Hunt wurde bereits in dieser Runde verwendet!")
        }
    }

    fun resetAbility() {
        used = false
    }
}