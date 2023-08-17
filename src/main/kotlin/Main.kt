fun main() {
    val helden = mutableListOf<Held>()

    val oreade = Oreade("Echo", 60)
    oreade.hp1 = 60

    val zombie = Zombie("Olivia", 70)
    zombie.hp3 = 70

    val magier = Magier("Magier Jack", 200)
    magier.hp = 200

    val golem = Golem("Golem", 100)
    golem.hp = 100
    golem.summon(magier)

    val vampir = Vampir("Barnabas", 80)
    vampir.hp2 = 80

    helden.add(oreade)
    helden.add(zombie)
    helden.add(vampir)

    val beutel = Beutel()

    println("Willkommen im Videospiel 'Golden Syntax'.")

    println("Willkommen in Golden Syntax! Tauche in eine magische Welt ein, in der du als Held einen epischen Kampf gegen den bösen Magier erlebst. Doch Vorsicht! Er kann einen Golem beschwören. Bist du bereit für diese Herausforderung? Dann zieh deinen Dolch, aktiviere deine Magie und stürze dich in den Kampf. Die Welt von Golden Syntax erwartet dich mit offenen Armen – komm und erlebe, wie du zu einer Legende wirst!")

    println("Wähle nun deine Gestalt. Es stehen drei zur Auswahl:")

    println("Die Oreade ${oreade.name} hat ${oreade.hp1} verfügbare Leben, dafür sind ihre Attacken umso stärker.")

    println("Der Vampir ${vampir.name} hat ${vampir.hp} verfügbare Leben, doch lass dir gesagt sein, der stärkste ist er nicht.")

    println("Der Zombie ${zombie.name} hat ${zombie.hp3} verfügbare Leben, dafür ist sie aber nicht die mutigste.")

    println("Such dir nun aus, welchen der drei du bespielen möchtest. Die flinke Echo? Den blutsaugenden Barnabas? Oder doch lieber die vergammelten Olivia?")


    val characterOfTheUser = readLine()

    val character = when (characterOfTheUser) {
        "Echo" -> oreade
        "Barnabas" -> vampir
        "Olivia" -> zombie
        else -> {
            println("Bitte wähle nur zwischen Echo, Barnabas und Olivia.")
            return
        }
    }
    helden.remove(character)

    println("Du hast ${character.name} als deine Gestalt gewählt. Viel Spaß im Kampf!")

    println("Nimm deinen Platz ein. Der Kampf beginnt!")

    var round = 1
    var gameOver = false

    while (!gameOver) {
        println("♥ ♥ ♥ ♥ ♥ ♥ Runde $round ♥ ♥ ♥ ♥ ♥ ♥")

                 println("${character.name} kann entweder angreifen oder den Beutel nutzen. Wähle angreifen oder beutel.")
                val heldAction = readLine()

                when (heldAction) {
                    "angreifen" -> {

                        //immer das gleiche attack, könnte man anpassen minimieren
                        if (!character.isDead()) {
                            if (character is Oreade) {
                                character.attack(magier)
                            } else if (character is Vampir) {
                                character.attack(magier)
                            } else if (character is Zombie) {
                                character.attack(magier)
                            }
                        }
                    }

                    "beutel" -> {
                        beutel.useBag()
                    }

                    else -> {
                        println("Ungültige Aktion gewählt.")
                    }
                }

//

        for (held in helden) {
            if (!held.isDead()) {
                held.randomAttack(magier)
            }
        }

        if (!magier.isDead()) {
            for (held in helden) { //Fehler, wenn Magier angreift, dann zieht er sich aus Karton raus Helden, meinen kann er nicht angreifen, da er nicht in Held ist
                if (!held.isDead()) {
                    magier.randomAttack(held)
                }
            }
        }



        //Doppelung, sinnvoll das raus zu machen? Hauptchara greift oben ja schon an:
      //  if (!character.isDead() && character.hasActedThisRound) {
        //    if (character is Oreade || character is Vampir || character is Zombie) {
        //        character.attack(magier)
        //    }
            // }

       if (golem.isDead() && magier.isDead()) {
           println("Die Helden haben den Golem und den Magier besiegt! Dein Team hat gesiegt. Golden Syntax dankt euch!")
             } else if (helden.all { it.isDead() }) {
            println("Alle Helden sind besiegt. Der Magier hat gesiegt. Das Spiel ist fertig.")
            gameOver = true
        }

        round++
    }
}


