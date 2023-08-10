class Hunt() {
    var hunt = (40..50).random()
    var damage = 40..50
    var used: Boolean = false

    fun huntUseAbility(target: Gegner) {
        if (used) {
            target.hp -= damage
            println("$hunt: Es richtet $damage Schaden an.")
            used = true
        } else {
            println("Hunt wurde bereits in dieser Runde verwendet!")
        }
    }

    fun resetAbility() {
        used = false
    }
}