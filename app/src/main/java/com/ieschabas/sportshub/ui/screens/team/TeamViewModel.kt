package com.ieschabas.sportshub.ui.screens.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ieschabas.sportshub.domain.model.Player
import com.ieschabas.sportshub.domain.model.Team
import com.ieschabas.sportshub.domain.repository.PlayerRepository
import com.ieschabas.sportshub.domain.repository.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val teamRepository: TeamRepository,
    private val playerRepository: PlayerRepository
) : ViewModel() {

    private val _team = MutableStateFlow<Team?>(null)
    val team: StateFlow<Team?> = _team.asStateFlow()

    private val _players = MutableStateFlow<List<Player>>(emptyList())
    val players: StateFlow<List<Player>> = _players.asStateFlow()

    fun loadTeam(teamId: String) {
        teamRepository.observeTeam(teamId)
            .onEach { _team.value = it }
            .launchIn(viewModelScope)

        playerRepository.observePlayersByTeam(teamId)
            .onEach { _players.value = it }
            .launchIn(viewModelScope)
    }
}
