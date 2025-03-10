package com.example.teamscheduleapp.presentation.view.homescreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.teamscheduleapp.R
import com.example.teamscheduleapp.data.remote.Game
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
* Displays a scheduled game item with team names, scores, logos, week, and game time.
*/
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduledGameItem(game: Game) {
    val instant = game.date.timestamp?.let { Instant.parse(it) }
    val dateFormatter = DateTimeFormatter.ofPattern("EEE, MMM d", Locale.getDefault()).withZone(ZoneId.systemDefault())
    val timeFormatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.getDefault()).withZone(ZoneId.systemDefault())
    val formattedDate = instant?.let { dateFormatter.format(it) } ?: "TBA"
    val formattedTime = instant?.let { timeFormatter.format(it) } ?: "TBA"

    val homeScore = game.homeScore?.takeIf { it.isNotEmpty() } ?: "0"
    val awayScore = game.awayScore?.takeIf { it.isNotEmpty() } ?: "0"

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.height_160))
            .padding(
                vertical = dimensionResource(id = R.dimen.small_16),
                horizontal = dimensionResource(id = R.dimen.small_20)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.small_8)),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = game.homeTeam.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black),
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = game.awayTeam.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black),
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$homeScore-$awayScore",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.grey),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = dimensionResource(id = R.dimen.small_12))
                )
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = "https://s3.amazonaws.com/yc-app-resources/nfl/logos/nfl_${game.homeTeam.triCode.lowercase()}_light.png",
                        contentDescription = game.homeTeam.name,
                        modifier = Modifier.size(50.dp)
                            .padding(end = dimensionResource(id = R.dimen.small_8))
                    )
                    Text(
                        text = "@",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.grey),
                    )
                    AsyncImage(
                        model = "https://s3.amazonaws.com/yc-app-resources/nfl/logos/nfl_${game.awayTeam.triCode.lowercase()}_light.png",
                        contentDescription = game.awayTeam.name,
                        modifier = Modifier.size(50.dp)
                            .padding(start = dimensionResource(id = R.dimen.small_8))
                    )
                }
                Text(
                    text = "$homeScore-$awayScore",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.grey),

                    modifier = Modifier
                        .weight(1f)
                        .padding(start = dimensionResource(id = R.dimen.small_12)),
                    textAlign = TextAlign.End
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = game.week,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.grey),
                    modifier = Modifier.padding(top = dimensionResource(id = R.dimen.small_4))
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.small_4)),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = formattedDate,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.grey),
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = formattedTime,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.grey),
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.End
                )
            }
        }
    }
}

