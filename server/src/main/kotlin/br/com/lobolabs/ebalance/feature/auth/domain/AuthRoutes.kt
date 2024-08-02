package br.com.lobolabs.ebalance.feature.auth.domain

import br.com.lobolabs.ebalance.feature.auth.domain.route.signInRoute
import br.com.lobolabs.ebalance.feature.auth.domain.route.signUpRoute
import br.com.lobolabs.ebalance.feature.auth.domain.route.recoveryPasswordRoute
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.authRoutes() {
    routing {
        signInRoute()
        signUpRoute()
        recoveryPasswordRoute()
    }
}
