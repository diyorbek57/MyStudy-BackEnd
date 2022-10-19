package uz.ayizor

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import uz.ayizor.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    DatabaseFactory.init()
    configureSecurity()
    configureMonitoring()
    configureSerialization()

}
