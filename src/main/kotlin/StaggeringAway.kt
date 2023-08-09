class StaggeringAway {
    var staggeringAway = (70..75).random()
    var damage = 70..75
    var used: Boolean = false

    fun staggeringUseAbility(target: Gegner) {
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