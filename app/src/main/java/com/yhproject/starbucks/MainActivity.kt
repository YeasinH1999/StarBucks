@file:Suppress("DEPRECATION")

package com.yhproject.starbucks

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.yhproject.starbucks.navigation.StarBucksNavigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            StarBucksNavigation()

        }
    }
}