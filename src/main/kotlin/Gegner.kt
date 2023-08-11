open class Gegner(var name: String, var hp: Int) {

     var hasActedThisRound: Boolean = false

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


