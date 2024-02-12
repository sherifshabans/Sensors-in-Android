package com.elsharif.sensorsinandroid.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
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
import androidx.core.content.getSystemService
import androidx.hilt.navigation.compose.hiltViewModel
import com.elsharif.sensorsinandroid.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ServiceCast")
@Composable
fun ProximitySensorScreen(
context: Context

) {
    val viewModel: MainViewModel = hiltViewModel()
    //val viewModel = viewModel<MainViewModel>()
    val distance = viewModel.distance
    var vibrator: Vibrator?

    var text = "cm$distance"

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
                    text = stringResource(id = R.string.proximity_name),
                    modifier = Modifier.weight(1f),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        modifier = Modifier.fillMaxSize(),

        ) {
        // make vibration in my phone when the sensor work

        if(distance.toInt()==0) {

            if (context.getSystemService(Context.VIBRATOR_SERVICE) != null) {
                vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator?.vibrate(
                        VibrationEffect.createOneShot(
                            500,
                            VibrationEffect.DEFAULT_AMPLITUDE
                        )
                    )
                } else {
                    vibrator?.vibrate(500)
                }
            } else {
                text = "No vibration"

            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
              Color(0xFF5AA382)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color =  Color.DarkGray
            )

        }

    }


}