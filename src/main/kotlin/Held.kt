open class Held(val name: String, var hp: Int) {
    val actions = mutableListOf<Action>()

    fun addAction(action: Action) {
        actions.add(action)
    }

    fun useAction(target: Held) {
        if (actions.isNotEmpty()) {
            val action = actions[0]
            action.execute(target)
            actions.removeAt(0)
        }
    }
}

