class Vampir(var name2: String , hp2: Int): Held(name2 , hp2) {
    init{
        addAction(bite(44 , Gegner()))
        addAction(camoCape(5 , Gegner()))
        addAction(manipulation(30 , Gegner()))
        addAction(scratch(20 , Gegner()))
    }

    private fun bite (damage: Int , target: Gegner) {
        println("$name2 beißt ${target.name} in den Hals und verursacht $damage Schaden.")
    }
    private fun camoCape(damage: Int , target: Gegner){
        println("$name2 wirft sich den Tarnumhang über und zwickt ${target.name}. Dabei entsteht $damage Schaden.")
    }

    private fun manipulation(damage: Int , target: Gegner){
        println("$name2 manipuliert ${target.name} und verursacht $damage Schaden.")
    }

    private fun scratch(damage: Int , target: Gegner){
        println("$name2 kratzt ${target.name} und verursacht $damage Schaden.")
    }
    private fun addAction(action: Unit) {}

}