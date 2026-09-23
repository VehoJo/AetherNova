@file:OptIn(ExperimentalMaterial3Api::class)

package com.vehojo.aethernova

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLocale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.vehojo.aethernova.ui.theme.BackgroundColor
import com.vehojo.aethernova.ui.theme.BlackGrad
import com.vehojo.aethernova.ui.theme.Orbitron_Bold
import com.vehojo.aethernova.ui.theme.PlusJakartaSans_Medium
import com.vehojo.aethernova.ui.theme.PlusJakartaSans_Regular
import com.vehojo.aethernova.ui.theme.PlusJakartaSans_SemiBold
import com.vehojo.aethernova.ui.theme.Purple
import com.vehojo.aethernova.ui.theme.White
import com.vehojo.aethernova.ui.theme.Yellow
import kotlinx.datetime.Instant
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun CreateEvents(onDismiss: () -> Unit) {
    val minNameLenght = 3
    val maxNameLenght = 10
    val maxDescriptionLenght = 100
    val formatter = remember { SimpleDateFormat("HH:mm", Locale.getDefault()) }
    var showTimePicker by remember { mutableStateOf(false) }
    var selectedTime: TimePickerState? by remember { mutableStateOf(null) }
    var showModal by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf<Long?>(null) }
    var textState by remember { mutableStateOf("") }
    var textStateD by remember { mutableStateOf("") }
    val nameErrorD = textStateD.length > maxDescriptionLenght
    val nameError =
        textState.isNotEmpty() &&
                textState.length !in minNameLenght..maxNameLenght
    if (showModal) {
        DatePickerModal(
            onDateSelected = {
                selectedDate = it
                showModal = false
            },
            onDismiss = { showModal = false }
        )
    }
    if (showTimePicker) {
        Dialog(onDismissRequest = { showTimePicker = false }) {
            Surface(
                shape = RoundedCornerShape(28.dp),
                color = BackgroundColor,
                tonalElevation = 6.dp
            ) {
                DialUseStateExample(
                    onDismiss = {
                        showTimePicker = false
                    },
                    onConfirm = { time ->
                        selectedTime = time
                        showTimePicker = false
                    },
                )
            }
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .width(320.dp)
                .wrapContentHeight()
                .clip(shape = RoundedCornerShape(28.dp))
                .background(color = BackgroundColor.copy(alpha = 0.9f))
                .border(
                    width = 2.dp, color = Color.White.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(28.dp)
                )
        ) {
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Text(
                        text = "CREATE EVENTS",
                        fontSize = 20.sp,
                        color = White,
                        fontFamily = Orbitron_Bold,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clickable{onDismiss()}
                            .size(30.dp)
                            .offset(x = (-15).dp, y = (-5).dp)
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
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(color = Purple)) {
                            append("EVENT NAME")
                        }
                        withStyle(SpanStyle(color = Color.Red)) {
                            append("*")
                        }
                    },
                    fontSize = 10.sp,
                    letterSpacing = 3.sp,
                    fontFamily = PlusJakartaSans_SemiBold,
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp)
                )
                OutlinedTextField(
                    value = textState,
                    onValueChange = {
                        textState = it
                    },
                    isError = nameError,
                    shape = RoundedCornerShape(15.dp),
                    textStyle = TextStyle(
                        color = White.copy(alpha = 0.7f),
                        fontSize = 14.sp,
                        fontFamily = PlusJakartaSans_Medium
                    ),
                    modifier = Modifier
                        .size(width = 300.dp, height = 60.dp)
                        .padding(start = 20.dp, top = 8.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(color = White.copy(alpha = 0.1f)),
                    placeholder = {
                        Text(
                            text = "Enter event name",
                            style = TextStyle(
                                color = White.copy(alpha = 0.4f),
                                fontSize = 14.sp,
                                fontFamily = PlusJakartaSans_Medium
                            )
                        )
                    },
                    singleLine = true
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(color = Purple)) {
                            append("DATE")
                        }
                        withStyle(SpanStyle(color = Color.Red)) {
                            append("*")
                        }
                    },
                    fontSize = 10.sp,
                    letterSpacing = 3.sp,
                    color = Purple,
                    fontFamily = PlusJakartaSans_SemiBold,
                    modifier = Modifier.padding(start = 16.dp, top = 20.dp)
                )
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .clickable { showModal = true }
                        .size(width = 300.dp, height = 60.dp)
                        .padding(start = 20.dp, top = 8.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(color = White.copy(alpha = 0.1f))
                        .border(
                            shape = RoundedCornerShape(15.dp),
                            width = 1.dp,
                            color = White.copy(alpha = 0.4f)
                        )
                ) {
                    Row {
                        Icon(
                            painter = painterResource(R.drawable.calendar_icon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.padding(start = 18.dp)
                        )
                        Text(
                            text = if (selectedDate != null) {
                                SimpleDateFormat(
                                    "dd MMM, yyyy",
                                    LocalLocale.current.platformLocale
                                ).format(Date(selectedDate!!))
                            } else (
                                    "01.01.2027"
                                    ),
                            fontSize = 14.sp,
                            fontFamily = PlusJakartaSans_Medium,
                            color = Color.White.copy(alpha = 0.9f),
                            modifier = Modifier.padding(start = 12.dp)
                        )
                    }
                }
                Text(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(color = Purple)) {
                            append("TIME")
                        }
                        withStyle(SpanStyle(color = Color.Red)) {
                            append("*")
                        }
                    },
                    fontSize = 10.sp,
                    letterSpacing = 3.sp,
                    color = Purple,
                    fontFamily = PlusJakartaSans_SemiBold,
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp)
                )
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .clickable { showTimePicker = true }
                        .size(width = 300.dp, height = 60.dp)
                        .padding(start = 20.dp, top = 8.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(color = White.copy(alpha = 0.1f))
                        .border(
                            shape = RoundedCornerShape(15.dp),
                            width = 1.dp,
                            color = White.copy(alpha = 0.4f)
                        )
                ) {
                    Row {
                        Icon(
                            painter = painterResource(R.drawable.icon_clock),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.padding(start = 18.dp)
                        )
                        if (selectedTime != null) {
                            val cal = Calendar.getInstance()
                            cal.set(Calendar.HOUR_OF_DAY, selectedTime!!.hour)
                            cal.set(Calendar.MINUTE, selectedTime!!.minute)
                            cal.isLenient = false
                            Text(
                                "${formatter.format(cal.time)}",
                                fontSize = 14.sp,
                                fontFamily = PlusJakartaSans_Medium,
                                color = Color.White.copy(alpha = 0.9f),
                                modifier = Modifier.padding(start = 12.dp)
                            )
                        } else {
                            Text(
                                "00:00",
                                fontSize = 14.sp,
                                fontFamily = PlusJakartaSans_Medium,
                                color = Color.White.copy(alpha = 0.9f),
                                modifier = Modifier.padding(start = 12.dp)
                            )
                        }
                    }
                }
                Text(
                    text = "DESCRIPTION",
                    fontSize = 10.sp,
                    letterSpacing = 3.sp,
                    color = Purple,
                    fontFamily = PlusJakartaSans_SemiBold,
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp)
                )
                OutlinedTextField(
                    value = textStateD,
                    onValueChange = {
                        textStateD = it
                    },
                    isError = nameErrorD,
                    shape = RoundedCornerShape(15.dp),
                    textStyle = TextStyle(
                        color = White.copy(alpha = 0.7f),
                        fontSize = 14.sp,
                        fontFamily = PlusJakartaSans_Medium
                    ),
                    modifier = Modifier
                        .width(300.dp)
                        .height(115.dp)
                        .padding(start = 20.dp, top = 15.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(color = White.copy(alpha = 0.1f)),
                    placeholder = {
                        Text(
                            text = "Add a short description",
                            style = TextStyle(
                                color = White.copy(alpha = 0.4f),
                                fontSize = 14.sp,
                                fontFamily = PlusJakartaSans_Medium
                            )
                        )
                    }
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.width (320.dp)
                ) {
                    Column {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .size(width = 280.dp, height = 55.dp)
                                .border(
                                    shape = RoundedCornerShape(16.dp),
                                    width = 2.dp,
                                    color = White.copy(alpha = 0.1f)
                                )
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(Purple, BlackGrad)
                                    ),
                                    shape = RoundedCornerShape(16.dp)
                                )
                        ) {
                            Text(
                                "CREATE EVENT",
                                fontSize = 14.sp,
                                fontFamily = Orbitron_Bold,
                                color = Color.White,
                            )
                        }

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .clickable {onDismiss()}
                                .padding(top = 12.dp)
                                .size(width = 280.dp, height = 55.dp)
                                .border(
                                    shape = RoundedCornerShape(16.dp),
                                    width = 2.dp,
                                    color = White.copy(alpha = 0.1f)
                                )
                        ) {
                            Text(
                                "CANCEL",
                                fontSize = 14.sp,
                                fontFamily = Orbitron_Bold,
                                color = White.copy(alpha = 0.9f),
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun DialUseStateExample(
    onConfirm: (TimePickerState) -> Unit,
    onDismiss: () -> Unit,
) {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )

    Column {
        TimePicker(
            state = timePickerState,
            colors = TimePickerDefaults.colors(
                containerColor = BackgroundColor,
                clockDialColor = BackgroundColor,
                clockDialSelectedContentColor = White,
                clockDialUnselectedContentColor = White.copy(alpha = 0.7f),
                selectorColor = Purple,
                timeSelectorSelectedContainerColor = Purple,
                timeSelectorSelectedContentColor = White,
                periodSelectorSelectedContainerColor = Purple,
                periodSelectorSelectedContentColor = White
            )
        )
        Row() {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(
                    containerColor = BackgroundColor
                ),
                modifier = Modifier
                    .padding(end = 10.dp)
            ) {
                Text(
                    "Cancel",
                    color = Purple
                )
            }
            Button(
                onClick = { onConfirm(timePickerState) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = BackgroundColor
                )
            ) {
                Text(
                    "OK",
                    color = Purple
                    )
            }
        }
    }
}

@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = null,
        yearRange = IntRange(2026, 2027),
        selectableDates = object: SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val calendar = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC")).apply {
                    timeInMillis = utcTimeMillis
                }
                val date = java.time.LocalDate.of(
                    calendar.get(java.util.Calendar.YEAR),
                    calendar.get(java.util.Calendar.MONTH) + 1,
                    calendar.get(java.util.Calendar.DAY_OF_MONTH)
                )
                return !date.isBefore(LocalDate.now()) && !date.isAfter(LocalDate.of(2027, 1, 1))
            }

            override fun isSelectableYear(year: Int): Boolean {
                return year in 2026..2027
            }
        }
    )
    DatePickerDialog(
        onDismissRequest = onDismiss,
        colors = DatePickerDefaults.colors(
            containerColor = BackgroundColor
        ),
        tonalElevation = 0.dp,
        confirmButton = {
            TextButton(
                onClick = {
                    onDateSelected(datePickerState.selectedDateMillis)
                    onDismiss()
                }
            ) {
                Text("OK",)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
    {
        DatePicker(
            state = datePickerState,
            colors = DatePickerDefaults.colors(
                containerColor = BackgroundColor,
                dayInSelectionRangeContainerColor = BackgroundColor,
                headlineContentColor = White,
                weekdayContentColor = White.copy(alpha = 0.5f),
                navigationContentColor = White,
                dayContentColor = White,
                disabledDayContentColor = White.copy(alpha = 0.5f),
                selectedDayContainerColor = Purple,
                selectedDayContentColor = White,
                yearContentColor = White.copy(alpha = 0.75f),
                disabledYearContentColor = White.copy(alpha = 0.5f),
                todayContentColor = Purple,
                todayDateBorderColor = Purple,
                dateTextFieldColors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Purple,
                    unfocusedTextColor = Purple,
                    disabledTextColor = White.copy(alpha = 0.7f),
                    errorTextColor = White.copy(alpha = 0.7f)
                )
            )
        )
    }
}

@Preview
@Composable
fun CreateEventsPreview() {
    CreateEvents(onDismiss = {})
}