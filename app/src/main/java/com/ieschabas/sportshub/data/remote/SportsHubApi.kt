package com.ieschabas.sportshub.data.remote

import com.ieschabas.sportshub.data.remote.dto.ClassificationDto
import com.ieschabas.sportshub.data.remote.dto.LeagueDto
import com.ieschabas.sportshub.data.remote.dto.MatchDto
import com.ieschabas.sportshub.data.remote.dto.PlayerDto
import com.ieschabas.sportshub.data.remote.dto.TeamDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SportsHubApi {

    // ── Classifications ──────────────────────────────────────────────────────
    @GET("classifications")
    suspend fun getClassifications(): List<ClassificationDto>

    @GET("classifications")
    suspend fun getClassificationsByLeague(
        @Query("leagueId") leagueId: String
    ): List<ClassificationDto>

    @GET("classifications/{id}")
    suspend fun getClassification(@Path("id") id: String): ClassificationDto

    // ── Leagues ───────────────────────────────────────────────────────────────
    @GET("leagues")
    suspend fun getLeagues(): List<LeagueDto>

    @GET("leagues/{id}")
    suspend fun getLeague(@Path("id") id: String): LeagueDto

    // ── Matches ───────────────────────────────────────────────────────────────
    @GET("matches")
    suspend fun getMatches(): List<MatchDto>

    @GET("matches/{id}")
    suspend fun getMatch(@Path("id") id: String): MatchDto

    // ── Teams ─────────────────────────────────────────────────────────────────
    @GET("teams")
    suspend fun getTeams(): List<TeamDto>

    @GET("teams/{id}")
    suspend fun getTeam(@Path("id") id: String): TeamDto

    @GET("teams")
    suspend fun getTeamsByLeague(@Query("leagueId") leagueId: String): List<TeamDto>

    // ── Players ───────────────────────────────────────────────────────────────
    @GET("players")
    suspend fun getPlayers(): List<PlayerDto>

    @GET("players/{id}")
    suspend fun getPlayer(@Path("id") id: String): PlayerDto

    @GET("players")
    suspend fun getPlayersByTeam(@Query("teamId") teamId: String): List<PlayerDto>
}
