class Nibble() {
    var nibble = (20..30).random()
    var damage = 20..30
    var used: Boolean = false

    fun nibbleUseAbility(target: Gegner) {
        if (used) {
            target.hp -= damage
            println("Nibble: Es richtet $damage Schaden an.")
            used = true
        } else {
            println("Nibble wurde bereits in dieser Runde verwendet!")
        }
    }

    fun resetAbility() {
        used = false
    }}