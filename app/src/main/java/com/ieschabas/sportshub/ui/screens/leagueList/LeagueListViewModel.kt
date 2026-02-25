package com.ieschabas.sportshub.ui.screens.leagueList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ieschabas.sportshub.domain.model.League
import com.ieschabas.sportshub.domain.repository.LeagueRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class LeagueListViewModel @Inject constructor(
    repository: LeagueRepository
) : ViewModel() {

    val league: StateFlow<List<League>> =
        repository.observeLeagues()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}
