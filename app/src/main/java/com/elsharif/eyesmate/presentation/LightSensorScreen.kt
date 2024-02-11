package com.elsharif.eyesmate.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.elsharif.eyesmate.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LightSensorScreen() {
   val viewModel: MainViewModel = hiltViewModel()
    //val viewModel = viewModel<MainViewModel>()
    val isDark = viewModel.isDark


    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.light_name),
                    modifier = Modifier.weight(1f),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        modifier = Modifier.fillMaxSize(),

        ) {


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    if (isDark) Color.DarkGray else Color.White
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isDark) {
                    "It's dark outside"
                } else {
                    "It's bright outside"
                },
                color = if (isDark) Color.White else Color.DarkGray
            )
        }

    }

}