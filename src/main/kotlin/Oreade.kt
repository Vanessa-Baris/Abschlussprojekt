class Oreade(val name1: String , var hp1: Int): Held(name1, hp1){
    //welche Klasse?

    var blossomMagicUsed = false
    var clairvoynaceUsed = false
    var darkThornsUsed = false
    var treeTrunkLongThrowUsed = false


     fun attack(target: Gegner) {
        println("Wähle deinen Angriff aus, tippe dazu eine Zahl von 1-3 ein.")
        var attackChoice = readln().toIntOrNull()

        when (attackChoice) {
            1 -> blossomMagic(50..75 , Gegner())
            2 -> clairvoyance(0 , Gegner())
            3 -> darkThorns(30..44 , Gegner())
            4 -> treeTrunkLongThrow(40..53 , Gegner())
            else -> {
                println("Ungültige Auswahl.")
            }
        }
        useAction1(target)
    }

    init {
        addAction(blossomMagic(50..75 , Gegner())
        addAction(clairvoyance(0 , Gegner())
        addAction(darkThorns(30..44 , Gegner())
        addAction(treeTrunkLongThrow(40..53 , Gegner())
    }

    private fun blossomMagic (damage: IntRange, target: Gegner) {
        target.hp -= damage.random()
        blossomMagicUsed = true
        println("$name1 wirft mit Blüten um sich herum und trifft ${target.name}. Es richtet $damage Schaden an.")
    }

    private fun clairvoyance(damage: Int , target: Gegner){
        target.hp -= damage
        clairvoynaceUsed = true
        println("$name1 verwendet Hellsicht und blockt die nächste Aktion von ${target.name}")
        isBlocked = true
        useAction(target)
    }

    private fun darkThorns(damage: IntRange, target: Gegner){
        target.hp -= damage.random()
        darkThornsUsed = true
        println("$name1 wirft dunkle Dornen in die Runde und trifft ${target.name} und verursacht $damage Schaden.")
    }

    private fun treeTrunkLongThrow(damage: IntRange, target: Gegner){
        target.hp -= damage.random()
        treeTrunkLongThrowUsed = true
        println("$name1 wirft einen Baumstamm und trifft ${target.name}. Es verursacht $damage Schaden.")
    }

}









