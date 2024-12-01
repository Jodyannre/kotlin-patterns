package structural/* Structural proxy pattern
is a structural design pattern that lets you provide a substitute or placeholder
for another object. A proxy controls access to the original object,
allowing you to perform something either before or after the request gets
through to the original object.
 */

class Disk {
    companion object {
        var list = mutableListOf<String>()
        fun add(item:String): Boolean = list.add(item)
        fun getItems(): String = list.joinToString(",")
    }
}


class NetworkService {
    fun callApi(item: String): Boolean {
        Disk.add(item)
        return true
    }

    fun getItemInCar(): String {
        return Disk.getItems()
    }
}

class DatabaseClass {

    fun saveResult(result: String): Boolean {
        Disk.add(result)
        return true
    }

    fun getResult(): String {
        return Disk.getItems()
    }
}


interface CartRepo {
    fun addToCart(item: String): Boolean
}

class AuthorizedUserCartRepo(
    val networkSerivce: NetworkService,
    val databaseClass: DatabaseClass): CartRepo {

    override fun addToCart(item: String): Boolean {
        // call network service
        val result = networkSerivce.callApi(item)
        // save data in cart
        databaseClass.saveResult(item)
        return result
    }

}

class GuestUserCartRepo(val databaseClass: DatabaseClass): CartRepo {

    override fun addToCart(item: String): Boolean {
        return databaseClass.saveResult(item)
    }

}


enum class ClientType(type:String) {
    GUEST("guest"),
    AUTHORIZED("authorized");

    companion object {
        fun getType(type:String):ClientType{
            return when(type){
                "guest" -> GUEST
                "authorized" -> AUTHORIZED
                else -> GUEST
            }
        }
    }
}

class ProxyCartRepo(
    val type: String,
    val networkSerivce: NetworkService,
    val databaseClass: DatabaseClass
) : CartRepo {

    var repo: CartRepo? = null

    override fun addToCart(item: String): Boolean {
        //get the type of user
        val type = ClientType.getType(this.type)

        //there is two secario
        if (type == ClientType.AUTHORIZED) {
            if (repo == null)
                repo = AuthorizedUserCartRepo(networkSerivce, databaseClass)
        } else
            if (repo == null)
                repo = GuestUserCartRepo(databaseClass)

        return repo!!.addToCart(item)
    }
}


/* Example of use
fun main() {
    val proxy = ProxyCartRepo(ClientType.GUEST.name,NetworkService(),DatabaseClass())

    println(proxy.repo)

    proxy.addToCart("Apple")
    proxy.addToCart("Pear")
    proxy.addToCart("Pineapple")

    println(proxy.networkSerivce.getItemInCar())
}
 */