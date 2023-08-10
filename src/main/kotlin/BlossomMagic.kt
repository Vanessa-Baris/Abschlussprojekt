class BlossomMagic() {
    var blossomMagic = (50..75).random()
    var damage = 50..75
    var used: Boolean = false

    fun useAbility(target: Gegner) {
        if (used) {
            target.hp -= damage.random()
            println("$blossomMagic: Es richtet $damage Schaden an.")
            used = true
        } else {
            println("Blossom Magic wurde bereits in dieser Runde verwendet!")
        }
    }

    fun resetAbility() {
        used = false
    }
}




