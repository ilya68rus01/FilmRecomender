package com.example.core.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

inline fun Fragment.launchWhenViewStarted(
    crossinline block: suspend CoroutineScopeWrapper.() -> Unit
) = viewLifecycleOwner.lifecycleScope.launchWhenStarted {
    CoroutineScopeWrapper(this).block()
}

class CoroutineScopeWrapper(
    val coroutineScope: CoroutineScope
) {
    fun <T> Flow<T>.observe(action: suspend (T) -> Unit) = onEach(action)
        .launchIn(coroutineScope)
}