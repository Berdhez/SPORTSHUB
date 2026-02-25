package com.ieschabas.sportshub.data.local.entities

import com.ieschabas.sportshub.domain.model.Classification

import androidx.room.Relation
import androidx.room.Embedded

data class TeamWithPlayers(
    @Embedded val team: TeamEntity,
    @Relation(parentColumn = "id", entityColumn = "teamId")
    val players: List<PlayerEntity>
)

data class LeagueWithTeams(
    @Embedded val league: LeagueEntity,
    @Relation(parentColumn = "id", entityColumn = "leagueId")
    val teams: List<TeamEntity>
)

data class ClubWithTeams(
    @Embedded val club: ClubEntity,
    @Relation(parentColumn = "id", entityColumn = "clubId")
    val teams: List<TeamEntity>
)

data class TeamWithClub(
    @Embedded val team: TeamEntity,
    @Relation(
        parentColumn = "clubId",
        entityColumn = "id"
    )
    val club: ClubEntity
)

data class TeamAndClassification(
    @Embedded val team: com.ieschabas.sportshub.domain.model.Team,
    @Relation(
        parentColumn = "id",
        entityColumn = "teamId"
    )
    val classification: Classification
)

data class ClassificationWithTeamAndClub(
    @Embedded val classification: ClassificationEntity,

    @Relation(
        parentColumn = "team_id",
        entityColumn = "id"
    )
    val team: TeamEntity,

    @Relation(
        parentColumn = "club_id",
        entityColumn = "id"
    )
    val club: ClubEntity
)

data class TeamWithHomeMatches(
    @Embedded val team: TeamEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "homeTeamId"
    )
    val homeMatches: List<MatchEntity>
)

data class TeamWithAwayMatches(
    @Embedded val team: TeamEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "awayTeamId"
    )
    val awayMatches: List<MatchEntity>
)

data class LeagueWithMatches(
    @Embedded val league: LeagueEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "leagueId"
    )
    val matches: List<MatchEntity>
)

data class TeamWithLeague(
    @Embedded val team: TeamEntity,
    @Relation(
        parentColumn = "leagueId",
        entityColumn = "id"
    )
    val league: LeagueEntity
)

data class UserWithFavoriteTeams(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId",
        associateBy = androidx.room.Junction(FavoriteTeamEntity::class)
    )
    val favoriteTeams: List<TeamEntity>
)

data class TeamWithFollowers(
    @Embedded val team: TeamEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "teamId",
        associateBy = androidx.room.Junction(FavoriteTeamEntity::class)
    )
    val users: List<UserEntity>
)

