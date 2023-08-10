class ChemicalBurn {
    var chemicalBurn = 20
    var damage = 20
    var used: Boolean = false

    fun burnUseAbility(target: Gegner) {
        if (used) {
            target.hp -= damage
            println("$chemicalBurn: Es richtet $damage Schaden an.")
            used = true
        } else {
            println("Bite wurde bereits in dieser Runde verwendet!")
        }
    }

    fun resetAbility() {
        used = false
    }
}
