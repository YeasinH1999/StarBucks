package com.yhproject.starbucks.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yhproject.starbucks.R

@Composable
fun LogoComponent(
    modifier : Modifier,
    size : Dp = 155.dp

) {

    Image(
        painterResource(id = R.drawable.logo),
        contentDescription = null,
        modifier = modifier.size(size)
    )


}