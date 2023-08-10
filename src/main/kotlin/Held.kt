abstract class Held(override val name: String, override var hp: Int) : EinheitHeld() {
    val actions = mutableListOf<Action>()

    open fun addAction(action: Unit) {
        actions.add(action)
    }

    open fun useAction1(target: Gegner) {
        if (actions.isNotEmpty()) {
            val action = actions[0]
            action.execute(target)
            actions.removeAt(0)
        } else {
            println("$name hat keine Attacken mehr.")
        }
    }
}

    //Von Chat GPT Anregung geholt und auf meine Bedürfnisse umgewandelt, da ich nicht wusste, wie ich blocken soll:

var isBlocked: Boolean = false


//Was ist hier der Fehler?

    fun useAction(target: Gegner) {
        if (actions.isNotEmpty()) {
            val action = actions[0]
            if (isBlocked) {
                println("$name ist geschützt und blockt die nächste Aktion.")
                isBlocked = false
            } else {
                action.execute(target)
            }
            actions.removeAt(0)
        }
    }
}

