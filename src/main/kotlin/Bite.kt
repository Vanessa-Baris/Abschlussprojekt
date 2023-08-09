class Bite() {
    var bite = (44..50).random()
    var damage = 44..50
    var used: Boolean = false

    fun biteUseAbility(target: Gegner) {
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