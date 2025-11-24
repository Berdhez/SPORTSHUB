package com.ieschabas.sportshub.ui.components

import android.R.color.white
import androidx.compose.animation.core.copy
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import com.ieschabas.sportshub.ui.theme.AzulPetroleo
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp

@Composable
fun MyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = AzulPetroleo
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = AzulPetroleo,

        )

    ) {
        Text(text = text)
    }
}

@Composable
fun MyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier.fillMaxWidth(),
        singleLine = true
    )
}

@Composable
fun MySwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,

            colors = SwitchDefaults.colors(
                checkedThumbColor = White,
                checkedTrackColor = AzulPetroleo,
                uncheckedThumbColor = Gray,
                uncheckedTrackColor = White
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label)

    }
}
