open class Held( val name: String,  var hp: Int) {

    var hasActedThisRound: Boolean = false
    var hasUsedBeutelThisRound: Boolean = false


    fun resetRound(): Boolean {
        hasActedThisRound = false
        hasUsedBeutelThisRound = false



    fun canActThisRound(): Boolean {
        return hasActedThisRound
    }

    fun markBeutelAsUsedThisRound() {
        hasUsedBeutelThisRound = true
    }

    fun markAsActedThisRound(): Boolean {
        hasActedThisRound = true
        return true
    }

    fun canUseBeutelThisRound(): Boolean {
        return hasUsedBeutelThisRound && hasActedThisRound
    }


    fun performAction(target: Gegner) {
        if (canActThisRound()) {
            println("$name kämpft gegen ${target.name}.")
            markAsActedThisRound()
        } else {
            println("$name hat bereits in dieser Runde gekämpft.")
        }
    }

    fun useBeutel(beutel: Beutel) {
        if (canUseBeutelThisRound()) {
            println("$name nutzt den Beutel.")
            beutel.markAsUsedThisRound()
            markBeutelAsUsedThisRound()
        } else {
            println("$name kann den Beutel in dieser Runde nicht mehr nutzen.")
        }
    }

}

    //Von Chat GPT Anregung geholt und auf meine Bedürfnisse umgewandelt, da ich nicht wusste, wie ich blocken soll:
     val actions: MutableList<(Gegner) -> Unit> = mutableListOf()
    //mutableListOf() habe ich aber selbst angelegt.

    //Ab hier dann wieder Chat GPT:
    var isBlocked: Boolean = false

    fun addAction(action: (Gegner) -> Unit) {
        actions.add(action)
}

    fun useAction(target: Gegner) {
        if (actions.isNotEmpty()) {
            val action = actions[0]
            if (isBlocked) {
                println("Echo ist geschützt und blockt die nächste Aktion.")
                isBlocked = false
            } else {
                action(target)
            }
            actions.removeAt(0)
        }
    }
}




