package uz.ayizor

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import uz.ayizor.futures.security.JwtService
import uz.ayizor.futures.security.hash
import uz.ayizor.futures.user.UserRepo
import uz.ayizor.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    DatabaseFactory.init()
    val db = UserRepo()
    val jwtService = JwtService()
    val hashFunction = { s:String -> hash(s) }
    configureSecurity()
    configureMonitoring()
    configureSerialization()
    configureRouting()

}
