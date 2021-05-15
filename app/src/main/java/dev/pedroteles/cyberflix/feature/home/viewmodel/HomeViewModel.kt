package dev.pedroteles.cyberflix.feature.home.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class HomeViewModel @ViewModelInject constructor(
    private val randomString: String
) : ViewModel() {

}