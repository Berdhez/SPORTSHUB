package com.ieschabas.sportshub.ui.screens.classification

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ieschabas.sportshub.domain.model.Classification
import com.ieschabas.sportshub.domain.repository.ClassificationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ClassificationViewModel @Inject constructor(
    private val repository: ClassificationRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val leagueId: String = savedStateHandle.get<String>("leagueId") ?: ""

    val classifications: StateFlow<List<Classification>> =
        if (leagueId.isEmpty()) {
            // mostramos todas
            repository.observeClassifications()
        } else {
            // filtramos por liga usando repository
            repository.observeClassificationsByLeague(leagueId)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}

