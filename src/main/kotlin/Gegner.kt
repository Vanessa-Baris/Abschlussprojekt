open class Gegner(override var name: String, override var hp: Int): EinheitGegner() {
    val actions = mutableListOf<Action>()

    open fun addAction2(action: Unit) {
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