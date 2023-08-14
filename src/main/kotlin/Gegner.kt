open class Gegner(var name: String, var hp: Int) {

     var hasActedThisRound: Boolean = false


    open fun resetRound(): Boolean {
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

    fun performAction(target: Held) {
        if (canActThisRound()) {
            println("$name kämpft gegen ${target.name}.")
            markAsActedThisRound()
        } else {
            println("$name hat bereits in dieser Runde gekämpft.")
        }
    }

    val actions: MutableList<(Held) -> Unit> = mutableListOf()

    fun addAction(action: (Held) -> Unit) {
        actions.add(action)
    }

    fun performActions(target: Held) {
        for (action in actions) {
            action(target)
        }
    }

    open fun isDead(): Boolean {
        return hp <= 0
    }
}




