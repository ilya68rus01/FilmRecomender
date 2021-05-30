package khrushchev.ilya.filmrecomender.ui

import androidx.lifecycle.ViewModel
import dagger.internal.InjectedFieldSignature
import khrushchev.ilya.filmrecomender.repository.Repository
import javax.inject.Inject


class ViewModel(
    val repository: Repository
) : ViewModel() {

}
