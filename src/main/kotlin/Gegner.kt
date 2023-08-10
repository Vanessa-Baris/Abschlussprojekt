open class Gegner {
    val actions = mutableListOf<Action>()

    open fun addAction(action: Action) {
        actions.add(action)
    }

    open fun useAction2(target: Held) {
        if (actions.isNotEmpty()) {
            val action = actions[0]
            action.execute(target)
            actions.removeAt(0)
        } else {
            println("$name hat keine Attacken mehr.")
        }
    }
}
}