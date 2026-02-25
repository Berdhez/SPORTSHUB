package com.ieschabas.sportshub.ui.screens.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ieschabas.sportshub.data.local.entities.PlayerEntity
import com.ieschabas.sportshub.domain.model.Team
import com.ieschabas.sportshub.domain.repository.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val repository: TeamRepository
) : ViewModel() {

    private val _team = MutableStateFlow<Team?>(null)
    val team: StateFlow<Team?> = _team.asStateFlow()

    private val _players = MutableStateFlow<List<PlayerEntity>>(emptyList())
    val players: StateFlow<List<PlayerEntity>> = _players.asStateFlow()

    fun loadTeam(teamId: String) {
        repository.observeTeam(teamId)
            .onEach { _team.value = it }
            .launchIn(viewModelScope)

        viewModelScope.launch {
            _players.value = repository.getPlayersByTeam(teamId)
        }
    }
}
