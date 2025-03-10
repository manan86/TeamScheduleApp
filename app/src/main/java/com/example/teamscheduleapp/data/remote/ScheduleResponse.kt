package com.example.teamscheduleapp.data.remote

import com.google.gson.annotations.SerializedName

/**
 * Data models representing the schedule response from the API.
 * Includes team details, game sections, individual game data, and opponent information.
 * Helps in structuring and parsing API responses efficiently.
 */
data class ScheduleResponse(
    @SerializedName("Team") val team: Team,
    @SerializedName("GameSection") val gameSections: List<GameSection>
)

data class Team(
    @SerializedName("TriCode") val triCode: String,
    @SerializedName("Name") val name: String,
    @SerializedName("City") val city: String
)

data class GameSection(
    @SerializedName("Heading") val heading: String,
    @SerializedName("Game") val games: List<Game>
)

data class Opponent(
    @SerializedName("TriCode") val triCode: String,
    @SerializedName("Name") val name: String
)


data class GameDate(
    @SerializedName("Timestamp") val timestamp: String
)

data class Game(
    @SerializedName("Week") val week: String,
    @SerializedName("GameState") val gameState: String,
    @SerializedName("AwayScore") val awayScore: String?,
    @SerializedName("HomeScore") val homeScore: String?,
    @SerializedName("Type") val type: String,
    @SerializedName("Date") val date: GameDate,
    @SerializedName("Opponent") val opponent: Opponent,
    @SerializedName("IsHome") val isHome: Boolean
) {
    val homeTeam: Opponent
        get() = if (isHome) TeamInfo else opponent

    val awayTeam: Opponent
        get() = if (isHome) opponent else TeamInfo

    companion object {
        val TeamInfo = Opponent(
            triCode = "GB",
            name = "PACKERS"
        )
    }
}
