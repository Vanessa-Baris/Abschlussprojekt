fun main() {

    val helden = mutableListOf<Held>()

    val oreade = Oreade("Echo" ,60)
    oreade.hp1 = 60

    val zombie = Zombie("Olivia" , 70)
    zombie.hp3 = 70

    val magier = Magier("Magier Jack" , 200)
    magier.hp = 200

    val golem = Golem("Golem" , 100)
    golem.hp = 100

    val vampir = Vampir("Barnabas" , 80)
    vampir.hp2 = 80


    println("Willkommen im Videospiel 'Golden Syntax'.")

    println("Willkommen in Golden Syntax! Tauche in eine magische Welt ein, in der du als Held einen epischen Kampf gegen den bösen Magier erlebst. Doch Vorsicht! Er kann einen Golem beschwören. Bist du bereit für diese Herausforderung? Dann zieh deinen Dolch, aktiviere deine Magie und stürze dich in den Kampf. Die Welt von Golden Syntax erwartet dich mit offenen Armen – komm und erlebe, wie du zu einer Legende wirst!")

    println("Wähle nun deine Gestalt. Es stehen drei zur Auswahl:")

    println("Die Oreade ${oreade.name} hat ${oreade.hp1} verfügbare Leben, dafür sind ihre Attacken umso stärker.")

    println("Der Vampir ${vampir.name} hat ${vampir.hp} verfügbare Leben, doch lass dir gesagt sein, der stärkste ist er nicht.")

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

    if (!character.isDead()) {
        if (character is Oreade) {
            character.attack(magier)
        } else if (character is Vampir) {
            character.attack(magier)
        } else if (character is Zombie) {
            character.attack(magier)
        }
    }


    var round = 1
    var gameOver = false

    while (!gameOver) {
        println("♥ ♥ ♥ ♥ ♥ ♥ Runde $round ♥ ♥ ♥ ♥ ♥ ♥")

        helden.forEach { held ->
            if (held !is Gegner) {
                held.randomAttack(golem)
                held.randomAttack(magier)
            } else {
                println("${held.name} ist kein Held.")
            }
        }

        if (golem.isDead() && magier.isDead()) {
            println("Die Helden haben den Golem und den Magier besiegt! Dein Team hat gesiegt. Golden Syntax dankt euch!")
            gameOver = true
        } else if (helden.all { it.isDead() }) {
            println("Alle Helden sind besiegt. Der Magier hat gesiegt. Das Spiel ist fertig.")
            gameOver = true
        }

        // Von Chat GPT, da ich mir den Code ständig zerschoss und nach zwei Stunden Sucherei nicht weiter wusste:
        helden.filter { it !is Gegner }.forEach { held ->
            if (!held.isDead() && !held.canActThisRound()) {
                held.performAction(magier)
                held.performAction(golem)
                held.markAsActedThisRound()
            }
        }

        // Von Chat GPT, da ich mir den Code ständig zerschoss und nach zwei Stunden Sucherei nicht weiter wusste:
        helden.filterIsInstance<Gegner>().forEach { gegner ->
            if (!gegner.isDead() && !gegner.canActThisRound()) {
                helden.filter { it !is Gegner && !it.isDead() }.randomOrNull()?.let { target ->
                    gegner.performAction(target)
                    gegner.markAsActedThisRound()
                }
            }
        }

        //Ab hier wieder meins:

        // Überprüfe, ob das Spiel zu Ende ist
        if (golem.hp <= 0 || helden.all { held -> held.hp <= 0 }) {
            gameOver = true
            println("Spiel beendet.")
        }

        round++
    }
}




