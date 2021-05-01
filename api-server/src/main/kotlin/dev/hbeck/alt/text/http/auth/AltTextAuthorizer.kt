package dev.hbeck.alt.text.http.auth

import dev.hbeck.alt.text.http.auth.principal.UserPrincipal
import io.dropwizard.auth.Authorizer


class AltTextAuthorizer<T : UserPrincipal> : Authorizer<T> {
    override fun authorize(principal: T, role: String): Boolean {
        return principal.roles.contains(role)
    }
}