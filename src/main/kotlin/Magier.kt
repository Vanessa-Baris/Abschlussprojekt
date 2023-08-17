class Magier(var nameM: String, var hpM: Int): Gegner(nameM , hpM) {

    // Private Variablen zur Verfolgung der genutzten Angriffe
    private var chemicalBurnUsed = false
    private var curseUsed = false
    private var howlerUsed = false
    private var hurricaneUsed = false
    private var fireballUsed = false
    //Instanz von Golem
    val golemInstance = Golem("Name des Golems", 100)


//Initalisierung, fügt Aktionen zur Liste hinzu
    init {
        addAction { target -> chemicalBurn(20, target) }
        addAction { target -> curse(target) }
        addAction { target -> summonGolem(golemInstance) }
        addAction { target -> fireball(30, target) }
        addAction { target -> hurricane(50, target) }
        addAction { target -> howler(10, target) }
    }

    //Funktion Chemical Burn
    fun chemicalBurn(damage: Int, target: Held) {
        target.hp -= 20
        chemicalBurnUsed = true
        println("Der Magier fügt ${target.name} $damage Schaden zu.")
    }

    //Funktion fireball
    fun fireball(damage: Int, target: Held) {
        target.hp -= 30
        fireballUsed = true
        println("Feuerball trifft auf ${target.name} und macht $damage Schaden.")
    }

    //Funktion hurricane
    fun hurricane(damage: Int, target: Held) {
        target.hp -= 50
        hurricaneUsed = true
        println("Orkan trifft auf ${target.name} und verursacht $damage Schaden.")
    }

    //Funktion howler
    fun howler(damage: Int, target: Held) {
        target.hp -= 10
        howlerUsed = true
        println("Der Magier Jack heult ohrenbetäubend und trifft ${target.name}, Er macht $damage Schaden.")
    }

    //Fluch Angriff, zieht pro Runde 10% Hp ab bis sich der Hp auf 20% auf reduziert
    //Von Stackoverflow übernommen:
    fun curse(target: Held) {
        val maxHp = target.hp
        val minHpValue = (maxHp * 0.2).toInt()
        val damage = (maxHp * 0.1).toInt()

        val remainingHp = target.hp - minHpValue
        //coerceAtLeast von DerPunkt in Karlsruhe
        val roundsToReachMinHp = (remainingHp / damage).coerceAtLeast(1)

        target.hp -= damage * roundsToReachMinHp
        println("Fluch verringert die HP von ${target.name} um $damage pro Runde.")
        println("${target.name}'s HP wird immer weiter reduziert: ${target.hp}")

        curseUsed = true
    }

    // Beschwört den Golem und übergibt die Instanz als Argument
    fun summonGolem(friend: Golem) {
      friend.summon()
    }

    //Zufälliger Angriff
    //Ab hier wieder meins:
    fun randomAttack(target: Held) {
        // Zufällige Auswahl eines Angriffs
        val attackChoice = (1..6).random()
        when (attackChoice) {
            1 -> fireball(30 , target)
            2 -> chemicalBurn(20 , target)
            3 -> curse(target)
            4 -> howler(10, target)
            5 -> hurricane(50 , target)
            //beschwört Golem
            6 -> { summonGolem(golemInstance)
            }
            else -> println("Ungültige Auswahl.")
        }
    }


}










