package com.example.shareddata.features.registeruser.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shareddata.ui.theme.SharedDataTheme

@Composable
fun RegisterUserScreen() {
    Column(

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                10.dp
            )
        ) {
            CustomTextField(
                value = "",
                onChange =  { newValue ->
                },
                placeholder = {
                    CustomPlaceHolder("Qual e seu nome?")
                }
            )
            CustomTextField(
                value = "",
                onChange =  { newValue ->
                },
                placeholder = {
                    CustomPlaceHolder("Qual sua idade?")
                }
            )
        }

       Column(
           modifier = Modifier.padding(
               horizontal = 7.dp,
               vertical = 10.dp
           ),
           verticalArrangement = Arrangement.spacedBy(
               3.dp
           )
       ) {
           Text(
               modifier = Modifier.padding(
                   horizontal = 2.dp,
                   vertical = 10.dp
               ),
               text = "Qual seu genero?",
               style = TextStyle(
                   fontSize = 17.sp,
                   color = MaterialTheme.colorScheme.tertiary
               )
           )
           CustomRadioButton(
               selected = false,
               textSupport = "Feminio"
           ) {

           }
           CustomRadioButton(
               selected = false,
               textSupport = "Masculino"
           ) {

           }
           CustomRadioButton(
               selected = false,
               textSupport = "Não quero responder"
           ) {

           }
       }


    }


}

@Composable
private fun CustomRadioButton(
    selected: Boolean = false,
    textSupport: String,
    onClick: () -> Unit,
){
    Row(
       horizontalArrangement = Arrangement.spacedBy(
           5.dp
       ),
        verticalAlignment = Alignment.CenterVertically
    )  {
        CompositionLocalProvider(
            (LocalMinimumInteractiveComponentSize provides 0.dp)
        ) {
            RadioButton(
                modifier = Modifier.scale(0.7f),
                colors = RadioButtonDefaults.colors(
                    unselectedColor = MaterialTheme.colorScheme.tertiary,
                    selectedColor =  MaterialTheme.colorScheme.primary
                ),
                selected = selected,
                onClick = onClick
            )
        }
        Text(
            text = textSupport,
            fontSize = 12.sp,
            style = TextStyle(
                color = MaterialTheme.colorScheme.tertiary
            )
        )
    }
}

@Composable
private fun CustomTextField(onChange: (text: String) -> Unit, value: String, placeholder: @Composable () -> Unit) {
    val lineColor = MaterialTheme.colorScheme.primary

    BasicTextField(
       modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 8.dp,
                horizontal = 15.dp
            )
            .drawBehind {
                drawLine(
                    color = lineColor,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 1.dp.toPx()
                )
            },
        onValueChange = onChange,
        value = value,
        textStyle = TextStyle(fontSize = 16.sp, color = MaterialTheme.colorScheme.primary),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        decorationBox = { innerTextField ->
            Box(modifier = Modifier.padding(vertical = 8.dp)) {
                if (value.isEmpty()) placeholder()
                innerTextField()
            }
        }
    )
}

@Composable
private fun CustomPlaceHolder(text: String){
    Text(text, style = TextStyle(
        fontSize = 12.sp,
        color = MaterialTheme.colorScheme.tertiary
    ))
}

@Preview
@Composable
fun RegisterUserScreenPreview() {
    SharedDataTheme {
        RegisterUserScreen()
    }
}

