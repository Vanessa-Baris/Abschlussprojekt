open class Gegner( var name: String,  var hp: Int) {

    open fun addAction2(action: Unit) {
        actions.add(action)
    }

    open fun useAction2(target: Held) {
        if (actions.isNotEmpty()) {
            val action = actions[0]
            action.execute(target)
            //Was will er bei target?
            actions.removeAt(0)
        } else {
            println("$name hat keine Attacken mehr.")
        }
    }
}

