package dev.pedroteles.cyberflix.commons.ext

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.pedroteles.cyberflix.commons.model.DefaultError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

fun ViewModel.safeLaunch(
    errorBlock: (error: DefaultError) -> Unit,
    block: suspend CoroutineScope.() -> Unit
) = viewModelScope.safeLaunch(block, errorBlock)

fun CoroutineScope.safeLaunch(
    block: suspend CoroutineScope.() -> Unit,
    errorBlock: (error: DefaultError) -> Unit
) {
    launch {
        try {
            block.invoke(this)
        } catch (e: Exception) {
            errorBlock.invoke(e.toDefaultError())
        }
    }
}