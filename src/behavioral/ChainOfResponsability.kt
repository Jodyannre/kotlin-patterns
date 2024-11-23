package behavioral
/* Behavioral pattern chain of responsability
is a behavioral design pattern that lets you pass requests along a chain of handlers.
Upon receiving a request, each handler decides either to process the request or to pass
it to the next handler in the chain.
 */


enum class Request {
    AUTH,ROLE,PERMISSION,NONE
}


interface Handler {
    fun handle(request: Request): Boolean
    fun setNext(handler: Handler):Handler
}

abstract class BaseHandler : Handler {
    private var nextHandler: Handler? = null

    override fun handle(request: Request): Boolean {
        if (nextHandler != null) {
            return nextHandler!!.handle(request)
        } else {
            println("Request could not be handled")
            return false
        }

    }
    override fun setNext(handler: Handler): Handler {
        this.nextHandler = handler
        return handler
    }
}

class AuthHandler: BaseHandler() {

    override fun handle(request: Request): Boolean {
        if (request == Request.AUTH) {
            println("AuthHandler: Proccessing auth request.")
            return true
        }
        println("AuthHandler couldn't handle request.")
        return super.handle(request)
    }
}

class RolesHandler: BaseHandler() {
    override fun handle(request: Request): Boolean {
        if (request == Request.ROLE) {
            println("RolesHandler: Proccessing roles request.")
            return true
        }
        println("RolesHandler couldn't handle request.")
        return super.handle(request)
    }
}

class PermissionHandler: BaseHandler() {
    override fun handle(request: Request): Boolean {
        if (request == Request.PERMISSION) {
            println("PermissionHandler: Proccessing permission request.")
            return true
        }
        println("PermissionHandler couldn't handle request.")
        return super.handle(request)
    }
}


/* Example of use

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
 */