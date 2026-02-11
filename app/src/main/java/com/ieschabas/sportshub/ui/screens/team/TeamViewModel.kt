package com.ieschabas.sportshub.ui.screens.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ieschabas.sportshub.domain.model.Team
import com.ieschabas.sportshub.domain.repository.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    repository: TeamRepository
) : ViewModel() {

    val teams: StateFlow<List<Team>> =
        repository.observeTeams()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}
