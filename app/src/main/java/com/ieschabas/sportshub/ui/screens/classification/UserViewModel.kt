package com.ieschabas.sportshub.ui.screens.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ieschabas.sportshub.domain.model.User
import com.ieschabas.sportshub.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    repository: UserRepository
) : ViewModel() {

    val users: StateFlow<List<User>> =
        repository.observeUsers()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}
