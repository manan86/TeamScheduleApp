package com.example.teamscheduleapp.presentation.view.homescreen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.teamscheduleapp.R

/**
 * Displays a "BYE" week message in a structured UI component.
 * Ensures consistent styling and layout dimensions.
 */
@Composable
fun ByeWeekItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.height_160))
            .padding(horizontal = dimensionResource(id = R.dimen.small_20)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.bye_week_text),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.grey)
        )
    }
}

