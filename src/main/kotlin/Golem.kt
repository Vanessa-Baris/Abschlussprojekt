
class Golem (val nameG: String , val hpG: Int): Gegner(nameG , hpG) {

    // Variablen zur Verfolgung von benutzten Aktionen
    var pushUsed = false
    var mudBreathUsed = false
    var kickUsed = false
    var flailUsed = false

    // Variable zur Verfolgung, ob der Golem beschworen wurde oder nicht
    var hasBeenSummoned: Boolean = false
    var hasAttackedThisRound: Boolean = false


    // Initialisierungsblock, der Aktionen für den Golem hinzufügt
    init {
        addAction { target -> push(5..10, target) }
        addAction { target -> mudBreath(15..20, target) }
        addAction { target -> kick(10..15, target) }
        addAction { target -> flail(5..10, target) }
    }

    //Push Funktion
    fun push(damage: IntRange, target: Held) {
        val damageAmount = damage.random()
        target.hp -= damageAmount
        pushUsed = true
        println("$nameG stößt ${target.name} weg und verursacht $damage Schaden.")
    }

    //mudBreath Funktion
    fun mudBreath(damage: IntRange, target: Held) {
        val damageAmount = damage.random()
        target.hp -= damageAmount
        mudBreathUsed = true
        println("$nameG wirft sich den Tarnumhang über und zwickt ${target.name}. Dabei entsteht $damage Schaden.")
    }

    //Kick Funktion
    fun kick(damage: IntRange, target: Held) {
        val damageAmount = damage.random()
        target.hp -= damageAmount
        kickUsed = true
        println("$nameG manipuliert ${target.name} und verursacht $damage Schaden.")
    }

    //Flail Funktion
    fun flail(damage: IntRange, target: Held) {
        val damageAmount = damage.random()
        target.hp -= damageAmount
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


    // Funktion für den Angriff des Golems auf einen Held
    //Und das hier mit Dennis:
    fun attackOnce(target: Held) {
        if (hasBeenSummoned && !hasAttackedThisRound) { //hier überprüft ob bereits beschworen und schon agiert in der Runde
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


