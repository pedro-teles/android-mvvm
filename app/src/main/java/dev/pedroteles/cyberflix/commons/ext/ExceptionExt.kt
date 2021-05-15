package dev.pedroteles.cyberflix.commons.ext

import dev.pedroteles.cyberflix.commons.model.DefaultError
import java.lang.Exception

fun Exception.toDefaultError() : DefaultError =
    DefaultError(
        errorMessage = this.message.orEmpty()
    )