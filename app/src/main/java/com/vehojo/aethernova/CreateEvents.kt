package com.vehojo.aethernova

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vehojo.aethernova.ui.theme.BackgroundColor
import com.vehojo.aethernova.ui.theme.Orbitron_Bold
import com.vehojo.aethernova.ui.theme.PlusJakartaSans_Medium
import com.vehojo.aethernova.ui.theme.PlusJakartaSans_Regular
import com.vehojo.aethernova.ui.theme.PlusJakartaSans_SemiBold
import com.vehojo.aethernova.ui.theme.Purple
import com.vehojo.aethernova.ui.theme.White

@Preview(showSystemUi = true)
@Composable
fun CreateEvents() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .size(width = 320.dp, height = 710.dp)
                .clip(
                    shape = RoundedCornerShape(28.dp)
                )
                .background(
                    color = BackgroundColor
                )
                .border(
                    width = 2.dp, color = Color.White.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(28.dp)
                )
        ) {
            Column() {
                Spacer(modifier = Modifier.width(15.dp))
                Row() {
                    Text(
                        text = "CREATE EVENTS",
                        fontSize = 20.sp,
                        color = White,
                        fontFamily = Orbitron_Bold,
                        modifier = Modifier.padding(start = 20.dp, top = 15.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clickable {}
                            .size(30.dp)
                            .offset(x = (-10).dp, y = 10.dp)
                            .border(
                                width = 1.dp, color = Color.White.copy(alpha = 0.1f),
                                shape = CircleShape
                            )
                            .background(
                                color = White.copy(alpha = 0.05f),
                                shape = CircleShape
                            )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.close_icon),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                }

                Text(
                    text = "Create a new countdown event and set the date, time, and details for your next AetherNova celebration",
                    fontSize = 14.sp,
                    color = White.copy(alpha = 0.6f),
                    fontFamily = PlusJakartaSans_Regular,
                    modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                )
                Text(
                    text = "EVENT NAME",
                    fontSize = 12.sp,
                    letterSpacing = 3.sp,
                    color = Purple,
                    fontFamily = PlusJakartaSans_SemiBold,
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp)
                )
            }
        }
    }
}