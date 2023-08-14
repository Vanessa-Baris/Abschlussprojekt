
class Golem (val nameG: String , val hpG: Int): Gegner(nameG , hpG) {

    var pushUsed = false
    var mudBreathUsed = false
    var kickUsed = false
    var flailUsed = false

    var hasBeenSummoned: Boolean = false
    var hasAttackedThisRound: Boolean = false


    init {
        addAction { target -> push(5..10, target) }
        addAction { target -> mudBreath(15..20, target) }
        addAction { target -> kick(10..15, target) }
        addAction { target -> flail(5..10, target) }
    }

    fun push(damage: IntRange, target: Held) {
        target.hp -= damage.random()
        pushUsed = true
        println("$nameG beißt ${target.name} in den Hals und verursacht $damage Schaden.")
    }

    fun mudBreath(damage: IntRange, target: Held) {
        target.hp -= damage.random()
        mudBreathUsed = true
        println("$nameG wirft sich den Tarnumhang über und zwickt ${target.name}. Dabei entsteht $damage Schaden.")
    }

    fun kick(damage: IntRange, target: Held) {
        target.hp -= damage.random()
        kickUsed = true
        println("$nameG manipuliert ${target.name} und verursacht $damage Schaden.")
    }

    fun flail(damage: IntRange, target: Held) {
        target.hp -= damage.random()
        flailUsed = true
        println("$nameG kratzt ${target.name} und verursacht $damage Schaden.")
    }

    //Die summon Funktion habe ich eine Inspiration auf Stackoverflow gefunden und auf mich angepasst:
    fun summon() {
        if (hasBeenSummoned) {
            println("Der Golem wurde beschworen!")
            hasBeenSummoned = true
        } else {
            println("Der Golem wurde bereits beschworen.")
        }
    }

    //Und das hier auch auf Stackoverlow:
    fun attackOnce(target: Held) {
        if (hasBeenSummoned && !hasAttackedThisRound) {
            val randomAttack = randomAttack()
            when (randomAttack) {
                "push" -> push(5..10, target)
                "mudBreath" -> mudBreath(15..20, target)
                "kick" -> kick(10..15, target)
                "flail" -> flail(5..10, target)
                else -> println("Der Golem kann nicht angreifen.")
            }
            hasAttackedThisRound = true
        } else {
            println("Der Golem kann nicht angreifen oder hat bereits in dieser Runde angegriffen.")
        }
    }


    //Ab hier wieder meins:

    fun randomAttack(): String? {
        val possibleAttacks = mutableListOf<String>()
        if (pushUsed) possibleAttacks.add("push")
        if (mudBreathUsed) possibleAttacks.add("mudBreath")
        if (kickUsed) possibleAttacks.add("kick")
        if (flailUsed) possibleAttacks.add("flail")
        return possibleAttacks.randomOrNull()
    }

    override fun resetRound(): Boolean {
        super.resetRound()
        hasAttackedThisRound = false
        return true
    }
}


