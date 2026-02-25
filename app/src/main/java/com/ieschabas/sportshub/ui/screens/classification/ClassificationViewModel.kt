package com.ieschabas.sportshub.ui.screens.classification

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ieschabas.sportshub.domain.model.Classification
import com.ieschabas.sportshub.domain.model.Team
import com.ieschabas.sportshub.domain.repository.ClassificationRepository
import com.ieschabas.sportshub.domain.repository.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ClassificationViewModel @Inject constructor(
    private val repository: ClassificationRepository,
    private val teamRepository: TeamRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val leagueId: String = savedStateHandle.get<String>("leagueId") ?: ""

    val classifications: StateFlow<List<Classification>> =
        if (leagueId.isEmpty()) {
            repository.observeClassifications()
        } else {
            repository.observeClassificationsByLeague(leagueId)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    val teams: StateFlow<List<Team>> =
        teamRepository.observeTeams()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}
