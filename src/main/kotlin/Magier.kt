class Magier(var nameM: String, var hpM: Int): Gegner(nameM , hpM) {

    // Private Variablen zur Verfolgung der genutzten Angriffe
    private var chemicalBurnUsed = false
    private var curseUsed = false
    private var howlerUsed = false
    private var hurricaneUsed = false
    private var fireballUsed = false
    //Instanz von Golem, mit Tutor gemacht:
    val golemInstance = Golem("Golem", 100)

//Ab hier wieder meins:
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
        val damageAmount = damage
        target.hp -= damageAmount
        chemicalBurnUsed = true
        println("Der Magier fügt ${target.name} $damageAmount Schaden zu.")
    }

    //Funktion fireball
    fun fireball(damage: Int, target: Held) {
        val damageAmount = damage
        target.hp -= damageAmount
        fireballUsed = true
        println("Feuerball trifft auf ${target.name} und macht $damageAmount Schaden.")
    }

    //Funktion hurricane
    fun hurricane(damage: Int, target: Held) {
        val damageAmount = damage
        target.hp -= damageAmount
        hurricaneUsed = true
        println("Orkan trifft auf ${target.name} und verursacht $damageAmount Schaden.")
    }

    //Funktion howler
    fun howler(damage: Int, target: Held) {
        val damageAmount = damage
        target.hp -= damageAmount
        howlerUsed = true
        println("Der Magier Jack heult ohrenbetäubend und trifft ${target.name}, Er macht $damageAmount Schaden.")
    }

    //Von Stackoverflow übernommen und auf mich ungewandelt:
    //Das!
    fun curse(target: Held) {
        val maxHp = target.hp
        val minHpValue = (maxHp * 0.2).toInt()
        val damage = (maxHp * 0.1).toInt()

        val remainingHp = target.hp - minHpValue
        //Diese Zeile habe ich von Chat GPT und auf mich umgewandelt:
        val roundsToReachMinHp = (remainingHp / damage).coerceAtLeast(1)

        //Ab hier wieder nichts übernommen und meins:
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
    //Mit Dennis Marx erarbeitet
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










