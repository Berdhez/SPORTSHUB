package com.ieschabas.sportshub.ui.screens.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ieschabas.sportshub.R
import com.ieschabas.sportshub.domain.repository.MatchRepository
import com.ieschabas.sportshub.domain.repository.TeamRepository
import com.ieschabas.sportshub.ui.components.Match
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject


@HiltViewModel
class MatchViewModel @Inject constructor(
    private val matchRepository: MatchRepository,
    private val teamRepository: TeamRepository
) : ViewModel() {

    val matches: StateFlow<List<com.ieschabas.sportshub.ui.components.Match>> =
        combine(
            matchRepository.observeMatches(),
            teamRepository.observeTeams()
        ) { matchesList, teamsList ->

            val teamMap = teamsList.associateBy { it.id }

            matchesList.map { match ->
                val homeTeamName = teamMap[match.homeTeamId]?.name ?: match.homeTeamId
                val awayTeamName = teamMap[match.awayTeamId]?.name ?: match.awayTeamId

                com.ieschabas.sportshub.ui.components.Match(
                    time = formatDate(match.dateUtc),
                    homeTeam = homeTeamName,
                    homeLogoRes = getLogoForTeam(match.homeTeamId),
                    awayTeam = awayTeamName,
                    awayLogoRes = getLogoForTeam(match.awayTeamId),
                    score = if (match.homeScore != null && match.awayScore != null)
                        "${match.homeScore} - ${match.awayScore}"
                    else null
                )
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    private fun getLogoForTeam(teamId: String): Int {
        return when (teamId) {
            "team_rm" -> R.drawable.logo1
            "team_fcb" -> R.drawable.logo2
            else -> R.drawable.logo1
        }
    }


    private fun formatDate(dateUtc: String): String {
        // Creamos un parser para la fecha ISO que viene de la BD
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault())
        parser.timeZone = TimeZone.getTimeZone("UTC")
        val date = parser.parse(dateUtc)

        // Formateamos a dd/MM HH:mm
        val formatter = SimpleDateFormat("dd/MM HH:mm", Locale.getDefault())
        return formatter.format(date!!)
    }


}