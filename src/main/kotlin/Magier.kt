import kotlin.random.Random

class Magier( var nameM: String,  var hpM: Int): Gegner(nameM , hpM){



    init {
        addAction2()
        addAction2()
        addAction2()
        addAction2()
        addAction2()
        addAction2()
    }

    private fun chemicalBurn(damage: IntRange , target: Held) {

    }


    private fun curse( damage: IntRange , target: Held){
}


    fun summonGolem(golem: Golem) {
        golem.summon()
    }


    private fun fireball(damage: IntRange , target: Held){


    }

    private fun hurricane(damage: IntRange , target: Held){

}

    private fun howler(damage: IntRange , target: Held){


    }
}