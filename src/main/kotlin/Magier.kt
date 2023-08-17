class Magier(var nameM: String, var hpM: Int): Gegner(nameM , hpM) {

    private var chemicalBurnUsed = false
    private var curseUsed = false
    private var howlerUsed = false
    private var hurricaneUsed = false
    private var fireballUsed = false
    val golemInstance = Golem("Name des Golems", 100)



    init {
        addAction { target -> chemicalBurn(20, target) }
        addAction { target -> curse(target) }
        addAction { target -> summonGolem(golemInstance) }
        addAction { target -> fireball(30, target) }
        addAction { target -> hurricane(50, target) }
        addAction { target -> howler(10, target) }
    }

    fun chemicalBurn(damage: Int, target: Held) {
        target.hp -= 20
        chemicalBurnUsed = true
        println("Der Magier fügt ${target.name} $damage Schaden zu.")
    }

    fun fireball(damage: Int, target: Held) {
        target.hp -= 30
        fireballUsed = true
        println("Feuerball trifft auf ${target.name} und macht $damage Schaden.")
    }

    fun hurricane(damage: Int, target: Held) {
        target.hp -= 50
        hurricaneUsed = true
        println("Orkan trifft auf ${target.name} und verursacht $damage Schaden.")
    }

    fun howler(damage: Int, target: Held) {
        target.hp -= 10
        howlerUsed = true
        println("Der Magier Jack heult ohrenbetäubend und trifft ${target.name}, Er macht $damage Schaden.")
    }

    //Von Stackoverflow übernommen:
    fun curse(target: Held) {
        val maxHp = target.hp
        val minHpValue = (maxHp * 0.2).toInt()
        val damage = (maxHp * 0.1).toInt()

        val remainingHp = target.hp - minHpValue
        val roundsToReachMinHp = (remainingHp / damage).coerceAtLeast(1)

        target.hp -= damage * roundsToReachMinHp
        println("Fluch verringert die HP von ${target.name} um $damage pro Runde.")
        println("${target.name}'s HP wird immer weiter reduziert: ${target.hp}")

        curseUsed = true
    }

    //Magier: wenn ausgeführt, dann setze ich Wert fest, aber diese var mit true von Magier, der Magier weiß ob er beschworen hat aber Golem weiß das nicht
    fun summonGolem(friend: Golem) {
      friend.summon()
    }


    //Ab hier wieder meins:
    fun randomAttack(target: Held) {
        val attackChoice = (1..6).random()
        when (attackChoice) {
            1 -> fireball(30 , target)
            2 -> chemicalBurn(20 , target)
            3 -> curse(target)
            4 -> howler(10, target)
            5 -> hurricane(50 , target)
            6 -> { summonGolem(golemInstance)
            }
            else -> println("Ungültige Auswahl.")
        }
    }


}










