package com.almalk.footballmatches.matches.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Matches(
    @SerialName("filters") var filters: Filters? = Filters(),
    @SerialName("resultSet") var resultSet: ResultSet? = ResultSet(),
    @SerialName("competition") var competition: Competition? = Competition(),
    @SerialName("matches") var matches: List<Match> = arrayListOf()
)
@Serializable
data class Filters(
    @SerialName("season") var season: String? = null
)
@Serializable
data class ResultSet(
    @SerialName("count") var count: Int? = null,
    @SerialName("first") var first: String? = null,
    @SerialName("last") var last: String? = null,
    @SerialName("played") var played: Int? = null
)
@Serializable
data class Competition(
    @SerialName("id") var id: Int? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("code") var code: String? = null,
    @SerialName("type") var type: String? = null,
    @SerialName("emblem") var emblem: String? = null
)

@Serializable
data class Area(
    @SerialName("id") var id: Int? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("code") var code: String? = null,
    @SerialName("flag") var flag: String? = null
)

@Serializable
data class Season(
    @SerialName("id") var id: Int? = null,
    @SerialName("startDate") var startDate: String? = null,
    @SerialName("endDate") var endDate: String? = null,
    @SerialName("currentMatchday") var currentMatchday: Int? = null,
    @SerialName("winner") var winner: String? = null
)

@Serializable
data class Team(
    @SerialName("id") var id: Int? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("shortName") var shortName: String? = null,
    @SerialName("tla") var tla: String? = null,
    @SerialName("crest") var crest: String? = null
)
@Serializable
data class Time(
    @SerialName("home") var home: Int? = null,
    @SerialName("away") var away: Int? = null
)
@Serializable
data class Score(
    @SerialName("winner") var winner: String? = null,
    @SerialName("duration") var duration: String? = null,
    @SerialName("fullTime") var fullTime: Time? = Time(),
    @SerialName("halfTime") var halfTime: Time? = Time()
)

@Serializable
data class Referees(
    @SerialName("id") var id: Int? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("type") var type: String? = null,
    @SerialName("nationality") var nationality: String? = null
)
@Serializable
data class Match(
    @SerialName("area") var area: Area? = Area(),
    @SerialName("competition") var competition: Competition? = Competition(),
    @SerialName("season") var season: Season? = Season(),
    @SerialName("id") var id: Int? = null,
    @SerialName("utcDate") var utcDate: String? = null,
    @SerialName("status") var status: String? = null,
    @SerialName("matchday") var matchday: Int? = null,
    @SerialName("stage") var stage: String? = null,
    @SerialName("group") var group: String? = null,
    @SerialName("lastUpdated") var lastUpdated: String? = null,
    @SerialName("homeTeam") var homeTeam: Team? = Team(),
    @SerialName("awayTeam") var awayTeam: Team? = Team(),
    @SerialName("score") var score: Score? = Score(),
    @SerialName("referees") var referees: ArrayList<Referees> = arrayListOf()
)