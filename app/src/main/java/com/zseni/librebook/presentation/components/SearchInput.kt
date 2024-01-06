package com.zseni.librebook.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zseni.librebook.R
import com.zseni.librebook.presentation.navigation.MainAction
import com.zseni.librebook.ui.theme.Typography
import com.zseni.librebook.ui.theme.mainText
import com.zseni.librebook.ui.theme.shadowText

@Composable
fun LabelView(title:String){
    Text(
        text = title,
        style = Typography.labelSmall,
        textAlign = TextAlign.Start,
        color = Color.Black)
}
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SearchInputField(
    label: String,
    value:String,
    onValueChange:(String) -> Unit
){
    val keyboardController = LocalSoftwareKeyboardController.current
    
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        value = value,
        onValueChange = {onValueChange(it)},
        label = { LabelView(title = label)},
        textStyle = Typography.bodyMedium,
        colors = TextFieldDefaults.textFieldColors(
            textColor = mainText,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = Color.LightGray,
            cursorColor = MaterialTheme.colorScheme.primary,
            placeholderColor = shadowText,
            disabledPlaceholderColor = Color.White
        ) ,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        )
    )
}

@Composable
fun TopBar(title: String, navController: NavController
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically ){
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = stringResource(id = R.string.back_button)
        , modifier = Modifier.clickable(onClick = {navController.popBackStack()}))
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = title, style = Typography.displaySmall, color = MaterialTheme.colorScheme.onPrimary)
    }

}
