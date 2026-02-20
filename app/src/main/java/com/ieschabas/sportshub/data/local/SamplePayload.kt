package com.ieschabas.sportshub.data.local



import com.ieschabas.sportshub.data.local.entities.ClubEntity
import com.ieschabas.sportshub.data.local.entities.ClassificationEntity
import com.ieschabas.sportshub.data.local.entities.FavoriteTeamEntity
import com.ieschabas.sportshub.data.local.entities.LeagueEntity
import com.ieschabas.sportshub.data.local.entities.MatchEntity
import com.ieschabas.sportshub.data.local.entities.PlayerEntity
import com.ieschabas.sportshub.data.local.entities.TeamEntity
import com.ieschabas.sportshub.data.local.entities.UserEntity

data class SamplePayload(
    val leagues: List<LeagueEntity>,
    val clubs: List<ClubEntity>,
    val teams: List<TeamEntity>,
    val players: List<PlayerEntity>,
    val matches: List<MatchEntity>,
    val classifications: List<ClassificationEntity>,
    val user: UserEntity,
    val favorites: List<FavoriteTeamEntity>
)

object SampleData {

    fun create(): SamplePayload {

        // 1) Leagues
        val leagues = listOf(
            LeagueEntity(id = "laliga", name = "LaLiga", country = "España", season = "2025/26", logoUrl = null),
            LeagueEntity(id = "premier", name = "Premier League", country = "Inglaterra", season = "2025/26", logoUrl = null)
        )

        // 2) Clubs (ojo: TeamEntity tiene clubId, y ClassificationEntity también tiene clubId)
        val clubs = listOf(
            ClubEntity(id = "club_rm", name = "Real Madrid"),
            ClubEntity(id = "club_fcb", name = "FC Barcelona"),
            ClubEntity(id = "club_val", name = "Valencia CF"),
            ClubEntity(id = "club_ars", name = "Arsenal"),
            ClubEntity(id = "club_mci", name = "Manchester City")
        )

        // 3) Teams (id único, leagueId y clubId coherentes)
        val teams = listOf(
            TeamEntity(
                id = "team_rm",
                leagueId = "laliga",
                clubId = "club_rm",
                name = "Real Madrid",
                city = "Madrid",
                founded = 1902,
                crestUrl = null
            ),
            TeamEntity(
                id = "team_fcb",
                leagueId = "laliga",
                clubId = "club_fcb",
                name = "FC Barcelona",
                city = "Barcelona",
                founded = 1899,
                crestUrl = null
            ),
            TeamEntity(
                id = "team_val",
                leagueId = "laliga",
                clubId = "club_val",
                name = "Valencia CF",
                city = "Valencia",
                founded = 1919,
                crestUrl = null
            ),
            TeamEntity(
                id = "team_ars",
                leagueId = "premier",
                clubId = "club_ars",
                name = "Arsenal",
                city = "London",
                founded = 1886,
                crestUrl = null
            ),
            TeamEntity(
                id = "team_mci",
                leagueId = "premier",
                clubId = "club_mci",
                name = "Manchester City",
                city = "Manchester",
                founded = 1880,
                crestUrl = null
            )
        )

        // 4) Players (teamId debe existir)
        val players = listOf(
            PlayerEntity(id = "p_rm_1", teamId = "team_rm", name = "Jugador RM 1", position = "GK", number = 1, nationality = "ES"),
            PlayerEntity(id = "p_rm_2", teamId = "team_rm", name = "Jugador RM 2", position = "DF", number = 4, nationality = "ES"),

            PlayerEntity(id = "p_fcb_1", teamId = "team_fcb", name = "Jugador FCB 1", position = "FW", number = 9, nationality = "AR"),
            PlayerEntity(id = "p_fcb_2", teamId = "team_fcb", name = "Jugador FCB 2", position = "MF", number = 8, nationality = "ES"),

            PlayerEntity(id = "p_val_1", teamId = "team_val", name = "Jugador VAL 1", position = "DF", number = 3, nationality = "ES"),

            PlayerEntity(id = "p_ars_1", teamId = "team_ars", name = "Jugador ARS 1", position = "FW", number = 11, nationality = "GB"),
            PlayerEntity(id = "p_mci_1", teamId = "team_mci", name = "Jugador MCI 1", position = "MF", number = 17, nationality = "BE")
        )

        // 5) Matches (leagueId + homeTeamId/awayTeamId deben existir)
        val matches = listOf(
            MatchEntity(
                id = "m_laliga_1",
                leagueId = "laliga",
                dateUtc = "2025-10-25T20:45:00Z",
                homeTeamId = "team_val",
                awayTeamId = "team_fcb",
                homeScore = null,
                awayScore = null,
                status = "SCHEDULED"
            ),
            MatchEntity(
                id = "m_laliga_2",
                leagueId = "laliga",
                dateUtc = "2025-10-28T19:00:00Z",
                homeTeamId = "team_rm",
                awayTeamId = "team_val",
                homeScore = 2,
                awayScore = 1,
                status = "FINISHED"
            ),
            MatchEntity(
                id = "m_premier_1",
                leagueId = "premier",
                dateUtc = "2025-10-26T16:30:00Z",
                homeTeamId = "team_ars",
                awayTeamId = "team_mci",
                homeScore = null,
                awayScore = null,
                status = "SCHEDULED"
            )
        )

        // 6) Classifications (OJO: tableName = "classifications" y requiere teamId + clubId)
        // En tu diseño actual, NO hay leagueId en ClassificationEntity, así que normalmente filtrarías por teams de una liga.
        val classifications = listOf(
            ClassificationEntity(
                id = "c_team_rm",
                teamId = "team_rm",
                leagueId = "laLiga",
                clubId = "club_rm",
                gamesPlayed = 10,
                victories = 8,
                lost = 1,
                ties = 1,
                totalPoints = 25
            ),
            ClassificationEntity(
                id = "c_team_fcb",
                teamId = "team_fcb",
                clubId = "club_fcb",
                gamesPlayed = 10,
                victories = 7,
                lost = 2,
                ties = 1,
                totalPoints = 22,
                leagueId = "laLiga",
            ),
            ClassificationEntity(
                id = "c_team_val",
                teamId = "team_val",
                clubId = "club_val",
                gamesPlayed = 10,
                victories = 6,
                lost = 2,
                ties = 2,
                totalPoints = 20,
                leagueId = "laLiga",
            ),
            ClassificationEntity(
                id = "c_team_ars",
                teamId = "team_ars",
                clubId = "club_ars",
                gamesPlayed = 10,
                victories = 7,
                lost = 1,
                ties = 2,
                totalPoints = 23,
                leagueId = "laLiga",
            ),
            ClassificationEntity(
                id = "c_team_mci",
                teamId = "team_mci",
                clubId = "club_mci",
                gamesPlayed = 10,
                victories = 6,
                lost = 2,
                ties = 2,
                totalPoints = 20,
                leagueId = "laLiga",
            )
        )

        // 7) User
        val user = UserEntity(
            id = "u1",
            fullName = "Nombre Apellido",
            username = "nombreusuario",
            email = "user@mail.com",
            memberSince = "2024-03-12",
            verified = true
        )

        // 8) Favorites (userId + teamId existentes)
        val favorites = listOf(
            FavoriteTeamEntity(userId = "u1", teamId = "team_val"),
            FavoriteTeamEntity(userId = "u1", teamId = "team_ars")
        )

        return SamplePayload(
            leagues = leagues,
            clubs = clubs,
            teams = teams,
            players = players,
            matches = matches,
            classifications = classifications,
            user = user,
            favorites = favorites
        )
    }
}
