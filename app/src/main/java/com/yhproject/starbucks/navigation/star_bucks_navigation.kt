package com.yhproject.starbucks.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yhproject.starbucks.screens.HomeScreen
import com.yhproject.starbucks.screens.ProductDetailsScreen
import com.yhproject.starbucks.screens.StartScreen

@Composable
fun StarBucksNavigation(){

    val navHostController = rememberNavController()
    
    NavHost(navController = navHostController, startDestination = start){

        composable(start){
            StartScreen(navHostController = navHostController)
        }

        composable(home){
            HomeScreen(navHostController = navHostController)
        }

        composable(product_details){
            ProductDetailsScreen(navHostController = navHostController)
        }


    }

}

const val start = "start_screen"
const val home = "home_screen"
const val product_details = "product_details_screen"