@file:OptIn(ExperimentalMaterial3Api::class)

package com.yhproject.starbucks.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.yhproject.starbucks.Menu
import com.yhproject.starbucks.R
import com.yhproject.starbucks.components.AppIconComponent
import com.yhproject.starbucks.components.IconComponent
import com.yhproject.starbucks.components.LogoComponent
import com.yhproject.starbucks.menuList
import com.yhproject.starbucks.ui.theme.Background
import com.yhproject.starbucks.ui.theme.DarkGray_1
import com.yhproject.starbucks.ui.theme.DarkGreen
import com.yhproject.starbucks.ui.theme.Gray_1
import com.yhproject.starbucks.ui.theme.TextColor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun HomeScreen(
    navHostController: NavHostController
) {

    var search by remember {
        mutableStateOf("")
    }
    var selected by remember {
        mutableStateOf(1)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Header()
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                item {
                    TextDescription()
                    Box{
                        SearchBarScreen(
                            text = search,
                            onValueChange = { search = it}
                        )
                        AppIconComponent(
                            icon = R.drawable.filter,
                            background = DarkGreen,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(55.dp)
                        )
                    }
                    
                    LazyRow(
                        modifier = Modifier.padding(vertical = 20.dp)
                    ){
                        items(menuList, key = {it.id}){
                            CustomChipScreen(menu = it, selected = it.id == selected){ data ->
                                selected = data
                            }
                        }
                    }
                    
                }
            }

        }

    }

}

@Composable
fun CustomChipScreen(
    menu: Menu,
    selected : Boolean,
    modifier: Modifier = Modifier,
    onValueChange: (Int) -> Unit
) {

    TextButton(onClick = {
        onValueChange(menu.id)
    },
        shape = RoundedCornerShape(22.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) DarkGreen else Gray_1,
            contentColor = if (selected) Color.White else TextColor
        ),
        contentPadding = PaddingValues(13.dp),
        modifier = Modifier.padding(end = 10.dp)
    ) {
        Text(
            text = menu.title, style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
            )
        )
    }

}


@Composable
fun SearchBarScreen(
    text : String,
    onValueChange : (String) -> Unit,
    modifier: Modifier = Modifier
) {

    TextField(
        value = text,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = stringResource(id = R.string.search),
                style = TextStyle(
                color = DarkGray_1,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400
                )
            )
                      },
        leadingIcon = {
            IconComponent(icon = R.drawable.search)
        },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.5.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = DarkGreen
        )
    )


}


@Composable
fun TextDescription() {
    Text(
        text = stringResource(id = R.string.our_way_of_loving_you_back),
        style = TextStyle(
            fontSize = 25.sp,
            fontWeight = FontWeight.W600,
            color = Color.Black
        ),
        modifier = Modifier.padding(vertical = 30.dp)
    )
}


@Composable
private fun Header() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        AppIconComponent(icon = R.drawable.menu)
        LogoComponent(modifier = Modifier.size(58.dp))
        AppIconComponent(icon = R.drawable.back)

    }


}