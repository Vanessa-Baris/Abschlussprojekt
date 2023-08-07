fun main() {
    println("Willkommen im Videospiel 'Golden Syntax'.")

    val oreade = Oreade("Echo", hp1 = 50)
    println("Die Oreade ${oreade.name} hat ${oreade.hp} HP.")

    val vampir = Vampir("Barnabas" , hp2 = 70)
    println("Der Vampir ${vampir.name2} hat ${vampir.hp} HP.")

    val zombie = Zombie("Olivia" , 60)
    println("Der Zombie ${zombie.name3} hat ${zombie.hp3} HP.")
}