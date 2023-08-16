//open class Held(open val name: String, open var hp: Int) {

//var hasActedThisRound: Boolean = false
//var hasUsedBeutelThisRound: Boolean = false

    //fun resetRound() {
    //    hasActedThisRound = false
    //    hasUsedBeutelThisRound = false
   // }

 //   open fun canActThisRound(): Boolean {
       // return hasActedThisRound
  //  }

   // open fun markBeutelAsUsedThisRound() {
  //      hasUsedBeutelThisRound = true
  //  }

  //  open fun markAsActedThisRound() {
   //     hasActedThisRound = true
  //  }


  //  open fun canUseBeutelThisRound(): Boolean {
  //      return hasUsedBeutelThisRound && hasActedThisRound
//    }

  //  open fun performAction(target: Gegner) {
    //    if (canActThisRound()) {
       //     println("$name kämpft gegen ${target.name}.")
       //     markAsActedThisRound()
    //    } else {
   //         println("$name hat bereits in dieser Runde gekämpft.")
  //      }
 //   }

  //  fun healing(amount: Int) {
    //    println("$name wird um $amount HP geheilt.")
    //    hp += amount
  //  }

 //   fun useHealing(amount: Int) {
  //      println("$name verwendet einen Heiltrank und stellt HP um die Hälfte der GesamtHP wieder her.")
   //     healing(amount)
  //  }

 //   fun power(factor: Double) {
   //     println("$name wird um ${factor * 100}% stärker.")
  //  }

  //  fun useVitamin() {
   //     println("$name verwendet ein Vitamin und wird dauerhaft um 10% stärker.")
   //     power(0.1)
  //  }


  //  val actions: MutableList<(Gegner) -> Unit> = mutableListOf()

  //  fun addAction(action: (Gegner) -> Unit) {
   //     actions.add(action)
 //   }

  //  fun performActions(target: Gegner) {
      //  for (action in actions) {
   //         action(target)
    //    }
 //   }
//}


//Von Chat GPT Anregung geholt und auf meine Bedürfnisse umgewandelt, da ich nicht wusste, wie ich blocken soll:
//val actions: MutableList<(Gegner) -> Unit> = mutableListOf()
//mutableListOf() habe ich aber selbst angelegt.

//Ab hier dann wieder Chat GPT:
//var isBlocked: Boolean = false

//fun addAction(action: (Gegner) -> Unit) {
 //   actions.add(action)
//}

//fun useAction(target: Gegner) {
  //  if (actions.isNotEmpty()) {
    //    val action = actions[0]
    //    if (isBlocked) {
     //       println("Echo ist geschützt und blockt die nächste Aktion.")
      //      isBlocked = false
      //  } else {
    //        action(target)
     //   }
     //   actions.removeAt(0)
//}

//open fun useHealing() {
//    val beutel = Beutel()
 //   if (beutel.canUseThisRound() && beutel.canUseHealing()) {
  //      println("$name verwendet einen Heiltrank und stellt HP um die Hälfte der GesamtHP wieder her.")
  //      healing(hp / 2)
  //      beutel.markAsUsedThisRound()
   //     beutel.remainingHealingPotions--
  //  } else {
  //      println("Der Heiltrank kann in dieser Runde nicht mehr verwendet werden.")
 //   }
//}

//open fun useVitamin() {
  //  val beutel = Beutel()
  //  if (beutel.canUseVitamin()) {
    //    println("$name verwendet ein Vitamin und wird dauerhaft um 10% stärker.")
  //      power(0.1)
 //       beutel.hasUsedVitamin = true
 //   } else {
  //      println("Das Vitamin kann nicht mehr verwendet werden.")
 //   }
//}


//open fun isDead(): Boolean {
 //   return hp <= 0
//}

//open fun randomAttack(target: Gegner) {
  //  println("$name führt eine normale Attacke aus.")
  //  val damage = 15
   // target.hp -= damage
  //  println("$name fügt ${target.name} $damage Schaden zu.")
//}


// Von IJ verbessert, wo ich nicht ganz konform bin:
//fun power(d: Double) {

//}

// Von IJ verbessert, wo ich nicht ganz konform bin:
//fun healing(i: Int) {

//}

// Von IJ verbessert, ich bin nicht so einverstanden, aber fand auch nach 30 min keinen anderen Weg:
//fun summonGolem(golem: Golem) {}













