import behavioral.AuthHandler
import behavioral.PermissionHandler
import behavioral.RolesHandler
import behavioral.Request

fun main() {

    val handler = AuthHandler()

    handler.setNext(RolesHandler()).setNext(PermissionHandler())

    handler.handle(Request.AUTH)
    handler.handle(Request.PERMISSION)
    handler.handle(Request.ROLE)
    handler.handle(Request.NONE)
}