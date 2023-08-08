open class Held(val name: String, var hp: Int) {
    val actions = mutableListOf<Action>()

    open fun addAction(action: Action) {
        actions.add(action)
    }

    open fun useAction(target: Held) {
        if (actions.isNotEmpty()) {
            val action = actions[0]
            //action.execute(target)
            actions.removeAt(0)
        } else {
            println("$name hat keine Attacken mehr.")
        }
    }

    //Von Chat GPT Anregung geholt und auf meine Bedürfnisse umgewandelt:
    var isBlocked: Boolean = false

    fun useAction(target: Held) {
        if (actions.isNotEmpty()) {
            val action = actions[0]
            if (isBlocked) {
                println("$name ist geschützt und blockt die nächste Aktion.")
                isBlocked = false
            } else {
                //action.execute(target)
            }
            actions.removeAt(0)
        }
}
