class TreeTrunkLongThrow() {
    var treeTrunkLongThrow = (40..53).random()
    var damage = 40..53
    var used: Boolean = false

    fun treeUseAbility(target: Gegner) {
        if (used) {
            target.hp -= damage.random()
            println("$treeTrunkLongThrow: Es richtet $damage Schaden an.")
            used = true
        } else {
            println("Tree Trunk Long Throw wurde bereits in dieser Runde verwendet!")
        }
    }

    fun resetAbility() {
        used = false
    }
}