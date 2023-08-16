fun main() {

    var golem = Golem("Golem", 100)
    var magier = Magier("Magier Jack", 200)

    val helden = mutableListOf<Held>()
    helden.add(Oreade("Echo", 50))
    helden.add(Vampir("Barnabas", 70))
    helden.add(Zombie("Olivia", 60))


    println("Willkommen im Videospiel 'Golden Syntax'.")

    println("Willkommen in Golden Syntax! Tauche in eine magische Welt ein, in der du als Held einen epischen Kampf gegen den bösen Magier erlebst. Doch Vorsicht! Er kann einen Golem beschwören. Bist du bereit für diese Herausforderung? Dann zieh deinen Dolch, aktiviere deine Magie und stürze dich in den Kampf. Die Welt von Golden Syntax erwartet dich mit offenen Armen – komm und erlebe, wie du zu einer Legende wirst!")

    println("Wähle nun deine Gestalt. Es stehen drei zur Auswahl:")

    val oreade = Oreade("Echo", 50)
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

    println("${character.name}, wähle deine Attacke:")
    println("1. Normale Attacke")
    println("2. Heiltrank verwenden")
    println("3. Vitamin verwenden")

    if (character is Oreade) {
        println("1. Blossom Magic")
        println("2. Clairvoyance")
        println("3. Dark Thorns")
        println("4. Tree Trunk Long Throw")
    } else if (character is Vampir) {
        println("1. Bite")
        println("2. Camo Cape")
        println("3. Manipulation")
        println("4. Scratch")
    } else if (character is Zombie) {
        println("1. Push")
        println("2. Hunt")
        println("3. Nibble")
        println("4. Staggering Away")
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
        // Aktionen des Spielers ausführen
        if (!character.isDead()) {
            println("${character.name}, wähle deine Attacke:")
            println("1. Normale Attacke")
            println("2. Heiltrank verwenden")
            println("3. Vitamin verwenden")

            if (character is Oreade) {
                println("4. Blossom Magic")
                println("5. Clairvoyance")
                println("6. Dark Thorns")
                println("7. Tree Trunk Long Throw")
            } else if (character is Vampir) {
                println("4. Bite")
                println("5. Camo Cape")
                println("6. Manipulation")
                println("7. Scratch")
            } else if (character is Zombie) {
                println("4. Push")
                println("5. Hunt")
                println("6. Nibble")
                println("7. Staggering Away")
            }

            val userChoice = readln().toIntOrNull()

            when (userChoice) {
                1 -> character.randomAttack(magier)
                2 -> character.useHealing()
                3 -> character.useVitamin()
                4, 5, 6, 7 -> {
                }
                else -> {
                    println("Ungültige Auswahl. Bitte wähle eine der angegebenen Optionen.")
                }
            }
        } else {
            character.randomAttack(golem)
        }

        // Überprüfe, ob das Spiel zu Ende ist
        if (golem.hp <= 0 || helden.all { held -> held.hp <= 0 }) {
            gameOver = true
            println("Spiel beendet.")
        }

        round++
    }
}




