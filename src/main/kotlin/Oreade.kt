class Oreade(val name1: String , var hp1: Int): Held(name1, hp1){
    init {
        addAction(blossomMagic(70 , Gegner()))
        addAction(clairvoyance(0 , Gegner()))
        addAction(darkThorns(30 , Gegner()))
        addAction(treeTrunkLongThrow(40 , Gegner()))
    }

    private fun blossomMagic (damage: Int , target: Gegner) {
        println("$name1 wirft mit Blüten um sich herum und trifft ${target.name}. Es richtet $damage Schaden an.")
    }

    private fun clairvoyance(damage: Int , target: Gegner){
        println("$name1 verwendet Hellsicht und blockt die nächste Aktion von ${target.name}")
        isBlocked = true
    }

    private fun darkThorns(damage: Int , target: Gegner){
        println("$name1 wirft dunkle Dornen in die Runde und trifft ${target.name} und verursacht $damage Schaden.")
    }

    private fun treeTrunkLongThrow(damage: Int , target: Gegner){
        println("$name1 wirft einen Baumstamm und trifft ${target.name}. Es verursacht $damage Schaden.")
    }

    private fun addAction(action: Unit) {}

}




