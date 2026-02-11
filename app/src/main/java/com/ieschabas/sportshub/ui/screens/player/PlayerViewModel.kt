package com.ieschabas.sportshub.ui.screens.player

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ieschabas.sportshub.domain.model.Player
import com.ieschabas.sportshub.domain.repository.PlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    repository: PlayerRepository
) : ViewModel() {

    val players: StateFlow<List<Player>> =
        repository.observePlayers()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}
