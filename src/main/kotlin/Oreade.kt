class Oreade(val name1: String , var hp1: Int): Held(name1, hp1){

    var oreade = Oreade("Echo" , 50)
    init {
        addAction(blossomMagic(70..75 , Gegner()))
        addAction(clairvoyance(0 , Gegner()))
        addAction(darkThorns(30..44 , Gegner()))
        addAction(treeTrunkLongThrow(40..53 , Gegner()))
    }

    private fun blossomMagic (damage: IntRange, target: Gegner) {
        var blossomMagic = BlossomMagic()
        var target.hp -= blossomMagic.damage
        blossomMagic.useAbility(target)
        println("$name1 wirft mit Blüten um sich herum und trifft ${target.name}. Es richtet $damage Schaden an.")
    }

    private fun clairvoyance(damage: Int , target: Gegner){
        var clairvoyance = Clairvoyance()
        var target. hp -= clairvoyance.damage
        clairvoyance.clairUseAbility(target)
        println("$name1 verwendet Hellsicht und blockt die nächste Aktion von ${target.name}")
        isBlocked = true
    }

    private fun darkThorns(damage: IntRange, target: Gegner){
        var darkThorns = DarkThorns()
        var target.hp -= darkThorns.damage
        darkThorns.darkUseAbility(target)
        println("$name1 wirft dunkle Dornen in die Runde und trifft ${target.name} und verursacht $damage Schaden.")
    }

    private fun treeTrunkLongThrow(damage: IntRange, target: Gegner){
        var treeTrunkLongThrow = TreeTrunkLongThrow()
        var target.hp -= treeTrunkLongThrow.damage
        treeTrunkLongThrow.treeUseAbility(target)
        println("$name1 wirft einen Baumstamm und trifft ${target.name}. Es verursacht $damage Schaden.")
    }

    var target = Gegner("Jack", 200)





    private fun addAction(action: Unit) {}

}




