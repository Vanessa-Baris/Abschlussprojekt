class Scratch() {
    var scratch = (20..35).random()
    var damage = 20..35
    var used: Boolean = false

    fun scratchUseAbility(target: Gegner) {
        if (used) {
            target.hp -= damage.random()
            println("$scratch: Es richtet $damage Schaden an.")
            used = true
        } else {
            println("Scratch wurde bereits in dieser Runde verwendet!")
        }
    }

    fun resetAbility() {
        used = false
    }}