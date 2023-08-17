open class Gegner(var name: String, var hp: Int) {

    val actions: MutableList<(Held) -> Unit> = mutableListOf()

    // Fügt eine Aktion zur Liste hinzu
    fun addAction(action: (Held) -> Unit) {
        actions.add(action)
    }

    //guckt ob tot ist der Gegner
    open fun isDead(): Boolean {
        return hp <= 0
    }


}




