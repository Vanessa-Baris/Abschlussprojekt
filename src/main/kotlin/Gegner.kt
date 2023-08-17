open class Gegner(var name: String, var hp: Int) {

    val actions: MutableList<(Held) -> Unit> = mutableListOf()

    fun addAction(action: (Held) -> Unit) {
        actions.add(action)
    }

    open fun isDead(): Boolean {
        return hp <= 0
    }


}




