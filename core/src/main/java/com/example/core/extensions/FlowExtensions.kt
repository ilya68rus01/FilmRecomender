package com.example.core.extensions
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope

inline fun Fragment.launchWhenViewStarted(
    crossinline block: suspend CoroutineScope.() -> Unit
) = viewLifecycleOwner.lifecycleScope.launchWhenStarted {
    block()
}