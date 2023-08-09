class TreeTrunkLongThrow() {
    var treeTrunkLongThrow = (40..53).random()
    var damage = 40..53
    var used: Boolean = false

    fun treeUseAbility(target: Gegner) {
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