class CamoCape() {
    var camoCape = (5..10).random()
    var damage = 5..10
    var used: Boolean = false

    fun camoUseAbility(target: Gegner) {
        if (used) {
            target.hp -= damage.random()
            println("$camoCape: Es richtet $damage Schaden an.")
            used = true
        } else {
            println("Camo Cape wurde bereits in dieser Runde verwendet!")
        }
    }

    fun resetAbility() {
        used = false
    }}