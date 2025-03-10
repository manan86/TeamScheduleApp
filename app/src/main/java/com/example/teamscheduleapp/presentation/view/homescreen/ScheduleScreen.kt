package com.example.teamscheduleapp.presentation.view.homescreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.teamscheduleapp.R
import com.example.teamscheduleapp.presentation.viewmodel.ScheduleViewModel

/**
 * Displays the schedule screen, including game sections, headers, and error handling.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleScreen(viewModel: ScheduleViewModel = hiltViewModel()) {
    val scheduleState by viewModel.scheduleState
    val errorState by viewModel.errorState

    Column {
        TopBar()

        if (!errorState.isNullOrEmpty()) {
            Text(
                text = errorState!!,
                color = Color.Red,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
        } else {
            LazyColumn {
                items(scheduleState) { section ->
                    SectionHeader(section.heading)
                    section.games.forEach { game ->
                        when (game.type) {
                            "S" -> ScheduledGameItem(game)
                            "F" -> FinalGameItem(game)
                            "B" -> ByeWeekItem()
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 2.dp,
                            color = colorResource(id = R.color.grey),
                        )
                    }
                }
            }
        }
    }
}

/** Section header with a gray background */
@Composable
fun SectionHeader(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color(0xFFD3D3D3)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.grey),
        )
    }
}

/** Top bar displaying the schedule title */
@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.large_64))

            .background(Color(0xFF004C54)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.title_schedule),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white),
        )
    }
}


