package uz.ayizor

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import uz.ayizor.plugins.*

fun main() {
    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        configureSecurity()
        configureMonitoring()
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
