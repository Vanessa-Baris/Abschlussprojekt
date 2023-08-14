import kotlin.random.Random

class Magier(var nameM: String, var hpM: Int): Gegner(nameM , hpM) {

    private var chemicalBurnUsed = false
    private var curseUsed = false
    private var howlerUsed = false
    private var hurricaneUsed = false
    private var fireballUsed = false
    private var summonGolemUsed = false


    init {
        addAction { target -> chemicalBurn(20, target) }
        addAction { target -> curse(target) }
        addAction { target -> summonGolem(target) }
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

    fun summonGolem(target: Held) {
        if (!summonGolemUsed) {
            target.summonGolem(Golem("Golem", 100))
            println("Der Magier beschwört einen Golem.")
            summonGolemUsed = true
        } else {
            println("Der Golem wurde bereits in dieser Runde beschworen.")
        }
    }


            fun randomAttack(): String? {
                val possibleAttacks = mutableListOf<String>()
                if (!chemicalBurnUsed) possibleAttacks.add("chemicalBurn")
                if (!curseUsed) possibleAttacks.add("curse")
                if (!howlerUsed) possibleAttacks.add("howler")
                if (!hurricaneUsed) possibleAttacks.add("hurricane")
                if (!fireballUsed) possibleAttacks.add("fireball")
                return possibleAttacks.randomOrNull()
            }

            override fun resetRound(): Boolean {
                super.resetRound()
                var hasAttackedThisRound = false
                chemicalBurnUsed = false
                curseUsed = false
                howlerUsed = false
                hurricaneUsed = false
                fireballUsed = false
                return true
            }
        }




