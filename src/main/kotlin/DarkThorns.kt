class DarkThorns() {
    var darkThorns = (70..75).random()
    var damage = 30..44
    var used: Boolean = false

    fun darkUseAbility(target: Gegner) {
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
    }
}



