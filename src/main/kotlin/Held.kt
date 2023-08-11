open class Held( val name: String,  var hp: Int)  {

    private var hasActedThisRound: Boolean = false

    fun resetRound(): Boolean {
        hasActedThisRound = false
        return true
    }

    fun canActThisRound(): Boolean {
        return hasActedThisRound
    }

    fun markAsActedThisRound(): Boolean {
        hasActedThisRound = true
        return true
    }

    fun performAction(target: Gegner) {
        if (canActThisRound()) {
            println("$name kämpft gegen ${target.name}.")
            markAsActedThisRound()
        } else {
            println("$name hat bereits in dieser Runde gekämpft.")
        }
    }
}

    //Von Chat GPT Anregung geholt und auf meine Bedürfnisse umgewandelt, da ich nicht wusste, wie ich blocken soll:
    private val actions: MutableList<(Gegner) -> Unit> = mutableListOf()
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




