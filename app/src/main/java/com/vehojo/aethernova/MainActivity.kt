package com.vehojo.aethernova

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vehojo.aethernova.ui.theme.BlackGrad
import com.vehojo.aethernova.ui.theme.Orbitron_Black
import com.vehojo.aethernova.ui.theme.Orbitron_Bold
import com.vehojo.aethernova.ui.theme.PlusJakartaSans_Bold
import com.vehojo.aethernova.ui.theme.PlusJakartaSans_Medium
import com.vehojo.aethernova.ui.theme.PlusJakartaSans_Regular
import com.vehojo.aethernova.ui.theme.PlusJakartaSans_SemiBold
import com.vehojo.aethernova.ui.theme.Purple
import com.vehojo.aethernova.ui.theme.White
import com.vehojo.aethernova.ui.theme.Yellow
import kotlinx.coroutines.delay
import java.time.Duration
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF0A0A12))
            ) {
                MHeader()
                NYProtocol()
                Milestones()
                NebulaStream()
                ButCelebration()
            }
        }
    }
}

@Preview()
@Composable
fun MHeader() {
    Column(modifier = Modifier
        .padding(start = 24.dp)
        .padding(WindowInsets.statusBars.asPaddingValues())
    ) {
        Spacer(
            modifier = Modifier.height(24.dp)
        )
        Text(
            text = "SYSTEM ACTIVE",
            fontSize = 16.sp,
            color = Purple,
            fontFamily = PlusJakartaSans_SemiBold
        )
        Text(text = buildAnnotatedString {
            withStyle(SpanStyle(color = White)) {
                append("AETHER")
            }
            withStyle(SpanStyle(color = Yellow)) {
                append("NOVA")
            }
        },
            fontSize = 29.sp,
            fontFamily = Orbitron_Bold
        )
    }
}

@Composable
fun pineapple(): List<Long> {
    var now by remember() {
        mutableStateOf(LocalDateTime.now())
    }
    LaunchedEffect(Unit) {
        while(true) {
            now = LocalDateTime.now()
            delay(1000)
        }
    }
    val newYear = LocalDateTime.of(
        now.year + 1,
        1,
        1,
        0,
        0
    )
    val duration = Duration.between(now, newYear)

    val days = duration.toDays()
    val hours = duration.toHours() %24
    val minutes = duration.toMinutes() %60
    val seconds = duration.seconds %60

    return listOf(days, hours, minutes, seconds)

}

@Preview
@Composable
fun NYProtocol() {
    val (days, hours, minutes, seconds) = pineapple()
    Column() {
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "NEW YEAR PROTOCOL",
                fontSize = 16.sp,
                color = Yellow,
                fontFamily = PlusJakartaSans_Bold,
                letterSpacing = 4.sp,
                style = TextStyle(
                    shadow = Shadow(
                        color = Yellow.copy(alpha = 0.5f),
                        offset = Offset(0f, -10f),
                        blurRadius = 20f
                    )
                )
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Countdown(
                    icon = R.drawable.block_hours,
                    value = "$days",
                    label = "DAYS"
                )

                Countdown(
                    value = "$hours",
                    label = "HOURS"
                )

                Countdown(
                    value = "$minutes",
                    label = "MINS"
                )

                Countdown(
                    icon = R.drawable.block_secs,
                    value = "$seconds",
                    label = "SEC",
                    labelColor = Color.Yellow.copy(alpha = 0.5f),
                    labelFont = PlusJakartaSans_Bold,
                    textColor = Yellow,
                    textStyle = TextStyle(
                        shadow = Shadow(
                            color = Yellow.copy(alpha = 0.5f),
                            offset = Offset(0f, -20f),
                            blurRadius = 60f
                        )
                    )
                )

            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
            ) {
            Box(
                modifier = Modifier
                    .size(size = 256.dp)
                    .border(
                        shape = CircleShape,
                        width = 5.dp,
                        color = Yellow
                    )
            )
            Text(
                text = "2027",
                fontSize = 52.sp,
                color = Color.White,
                fontFamily = Orbitron_Black
            )
        }
    }
}

@Preview
@Composable
fun Milestones() {
    Spacer(modifier = Modifier.height(37.dp))
    Column() {
        Row {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.align(Alignment.Center)) {
                    Icon(
                        painter = painterResource(R.drawable.milestone_block),
                        contentDescription = null,
                        tint = Color.Unspecified,
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.CenterStart)
                            .offset(x = 16.dp)
                            .background(
                                color = Purple.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(8.dp)
                            )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.lightning),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(start = 100.dp)
                        .align(Alignment.CenterStart)
                ) {
                    Text(
                        text = "Next Milestones",
                        fontSize = 12.sp,
                        color = White.copy(alpha = 0.6f),
                        fontFamily = PlusJakartaSans_Medium,
                    )
                    Text(
                        text = "Atmospheric Fireworks",
                        fontSize = 16.sp,
                        color = White,
                        fontFamily = PlusJakartaSans_SemiBold,
                    )
                }
                Text(
                    text = "09:32",
                    fontSize = 12.sp,
                    color = Purple,
                    fontFamily = Orbitron_Bold,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 45.dp)
                )
            }
        }
    }
}

@Composable
@Preview
fun NebulaStream() {
    Spacer(modifier = Modifier.height(12.dp))
    Column() {
        Row {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.align(Alignment.Center)) {
                    Icon(
                        painter = painterResource(R.drawable.nebula_block),
                        contentDescription = null,
                        tint = Color.Unspecified,
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.CenterStart)
                            .offset(x = 16.dp)
                            .background(
                                color = Yellow.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(8.dp)
                            )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.note),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(start = 100.dp)
                        .align(Alignment.CenterStart)
                ) {
                    Text(
                        text = "Nebula Stream",
                        fontSize = 12.sp,
                        color = White.copy(alpha = 0.6f),
                        fontFamily = PlusJakartaSans_Medium,
                    )
                    Text(
                        text = "Synthesized Echoes",
                        fontSize = 16.sp,
                        color = White,
                        fontFamily = PlusJakartaSans_SemiBold,
                    )
                }
                Icon(
                    painter = painterResource(R.drawable.question),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 45.dp)
                )
            }
        }
    }
}

@Composable
fun Countdown(
    icon: Int = R.drawable.block_time,
    value: String,
    label: String,
    labelColor: Color = Color.White.copy(alpha = 0.5f),
    labelFont: FontFamily = PlusJakartaSans_Regular,
    textColor: Color = Color.White,
    textStyle: TextStyle? = null
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Text(
                text = value,
                fontSize = 30.sp,
                color = textColor,
                fontFamily = Orbitron_Black,
                style = textStyle ?: TextStyle()
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            fontSize = 9.sp,
            color = labelColor,
            fontFamily = labelFont
        )
    }
}

@Composable
@Preview
fun ButCelebration() {
    Spacer(modifier = Modifier.height(22.dp))
    Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(width = 354.dp, height = 54.dp)
                .clickable{}
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Purple, BlackGrad)
                    ),
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Text(
                "RESERVE CELEBRATION",
                fontSize = 14.sp,
                fontFamily = Orbitron_Bold,
                color = Color.White,
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun MMain() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF0A0A12))
    ) {
        MHeader()
        NYProtocol()
        Milestones()
        NebulaStream()
        ButCelebration()
    }
}