package creational/* Creational pattern Singleton */
/* Limit the instances of a class to one*/

class SingleDB private constructor() {
    companion object{
        @Volatile private var instance: SingleDB? = null
        private val playersList: MutableList<String> = mutableListOf()
        fun getInstance(): SingleDB {
            if (instance == null){
                instance = SingleDB()
            }
            return instance!!
        }
    }
    fun addPlayer(player: String) = playersList.add(player)
    fun removePlayer(player: String) = playersList.remove(player)
    fun getPlayers() = playersList.joinToString(",")
}


/* Example of use */

/*
    val db = creational.SingleDB.getInstance()

    db.addPlayer("Riquelme")
    db.addPlayer("Neymar")

    val db2 = creational.SingleDB.getInstance()
    db2.addPlayer("Messi")
    db2.addPlayer("Ronaldo")
    val db3 = creational.SingleDB.getInstance()
    println(db3.getPlayers())
 */