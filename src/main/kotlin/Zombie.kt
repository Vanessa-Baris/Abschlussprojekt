class Zombie(val name3: String, var hp3: Int): Held(name3 , hp3) {
    //Was mache ich da? Implement oder abstract?

    override fun attack(target: Gegner) {
        println("Wähle deinen Angriff aus, tippe dazu eine Zahl von 1-3 ein.")
        var attackChoice = readln().toIntOrNull()

        when (attackChoice) {
            1 -> push(30..33 , Gegner())
            2 -> hunt(40..50 , Gegner())
            3 -> nibble(20..30 , Gegner())
            4 -> staggeringAway(0 , Gegner())
            else -> {
                println("Ungültige Auswahl.")
            }
        }
        useAction1(target)
    }

    var zombie = Zombie("Olivia" , 60)
    init {
        addAction(push(30..33 , Gegner()))
        addAction(hunt(40..50 , Gegner()))
        addAction(nibble(20..30 , Gegner()))
        addAction(staggeringAway(0 , Gegner()))
    }

    private fun push(damage: IntRange, target: Gegner) {
        var push = Push()
        target.hp -= push.damage.random()
        push.pushUseAbility(target)
        println("$name3 schlägt ${target.name} und verursacht $damage Schaden.")
    }

    private fun hunt(damage: IntRange, target: Gegner) {
        var hunt = Hunt()
        target.hp = target.hp - hunt.damage.random()
        hunt.huntUseAbility(target)
        println("$name3 jagt ${target.name} hinterher und verursacht $damage Schaden.")
    }

    private fun nibble(damage: IntRange, target: Gegner) {
        var nibble = Nibble()
        target.hp -= nibble.damage.random()
        nibble.nibbleUseAbility(target)
        println("$name3 knabbert ${target.name} mit großen Genuss an und verursacht $damage Schaden.")
    }

    private fun staggeringAway(damage: Int , target: Gegner) {
        var staggeringAway = StaggeringAway()
        target.hp -= staggeringAway.damage.random()
        staggeringAway.staggeringUseAbility(target)
        println("$name3 wird das alles zu viel. $name3 torkelt weg um zu fliehen und setzt eine Runde aus.")
    }

    override fun addAction(action: Unit) {}

}