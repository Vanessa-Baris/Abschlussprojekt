
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
        println("$nameG stößt ${target.name} weg und verursacht $damage Schaden.")
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
        if (!hasBeenSummoned) {
            println("Der Golem wurde beschworen!")
            hasBeenSummoned = true
        } else {
            println("Der Golem wurde bereits beschworen.")
        }
    }



    //Und das hier mit Dennis:
    fun attackOnce(target: Held) {
        if (hasBeenSummoned && !hasAttackedThisRound) {
            val attackChoice = (1..4).random()
            when (attackChoice) {
                1 -> push(5..10, target)
                2 -> mudBreath(15..20, target)
                3 -> kick(10..15 , target)
                4 -> flail(10..10, target)
                else -> println("Ungültige Auswahl.")
            }

            hasAttackedThisRound = true
        } else {
            println("Der Golem kann nicht angreifen oder hat bereits in dieser Runde angegriffen.")
        }
    }
}


