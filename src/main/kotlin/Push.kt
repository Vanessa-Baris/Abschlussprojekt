class Push() {
    var hunt = (30..33).random()
    var damage = 30..33
    var used: Boolean = false

    fun pushUseAbility(target: Gegner) {
        if (used) {
            target.hp -= damage.random()
            println("$hunt: Es richtet $damage Schaden an.")
            used = true
        } else {
            println("Push wurde bereits in dieser Runde verwendet!")
        }
    }

    fun resetAbility() {
        used = false
    }}