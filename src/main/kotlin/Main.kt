fun main() {

    var golem = Golem("Golem" , 100)
    var magier = Magier("Magier Jack" , 200)

    val helden = mutableListOf<Held>()
    helden.add(Oreade("Echo", 50))
    helden.add(Vampir("Barnabas", 70))
    helden.add(Zombie("Olivia", 60))


    println("Willkommen im Videospiel 'Golden Syntax'.")

    println("Willkommen in Golden Syntax! Tauche in eine magische Welt ein, in der du als Held einen epischen Kampf gegen den bösen Magier erlebst. Doch Vorsicht! Er kann einen Golem beschwören. Bist du bereit für diese Herausforderung? Dann zieh deinen Dolch, aktiviere deine Magie und stürze dich in den Kampf. Die Welt von Golden Syntax erwartet dich mit offenen Armen – komm und erlebe, wie du zu einer Legende wirst!")

    println("Wähle nun deine Gestalt. Es stehen drei zur Auswahl:")

    val oreade = Oreade("Echo",  50)
    println("Die Oreade ${oreade.name} hat ${oreade.hp1} verfügbare Leben, dafür sind ihre Attacken umso stärker.")

    val vampir = Vampir("Barnabas", 70)
    println("Der Vampir ${vampir.name} hat ${vampir.hp} verfügbare Leben, doch lass dir gesagt sein, der stärkste ist er nicht.")

    val zombie = Zombie("Olivia", 60)
    println("Der Zombie ${zombie.name} hat ${zombie.hp3} verfügbare Leben, dafür ist sie aber nicht die mutigste.")

    println("Such dir nun aus, welchen der drei du bespielen möchtest. Die flinke Echo? Den blutsaugenden Barnabas? Oder doch lieber die vergammelten Olivia?")

    val characterOfTheUser = readln()

    val character = when (characterOfTheUser) {
        "Echo" -> oreade
        "Barnabas" -> vampir
        "Olivia" -> zombie
        else -> {
            println("Bitte wähle nur zwischen Echo, Barnabas und Olivia.")
            return
        }
    }
    println("Du hast ${character.name} als deine Gestalt gewählt. Viel Spaß im Kampf!")

    println("Nimm deinen Platz ein. Der Kampf beginnt!")




}