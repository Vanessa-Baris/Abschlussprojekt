class Clairvoyance() {
    var clairvoyance = 0
    var damage = 0
    var used: Boolean = false

    fun clairUseAbility(target: Gegner) {
        if (used) {
            target.hp -= damage
            println("Clairvoyance: Es richtet $damage Schaden an.")
            used = true
        } else {
            println("Clairvoyance wurde bereits in dieser Runde verwendet!")
        }
    }

    fun resetAbility() {
        used = false
    }
}




