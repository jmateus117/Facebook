package me.juanmateus.facebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.juanmateus.facebook.ui.screens.FacebookLoginScreen
import me.juanmateus.facebook.ui.screens.FacebookRegisterScreen
import me.juanmateus.facebook.ui.screens.FeedScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val miNavController = rememberNavController()


            NavHost(
                navController =  miNavController,
                startDestination = "login",
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = "login"){
                    FacebookLoginScreen(onClickRegister = {
                        miNavController.navigate(route="register") },
                        onClickIniciarSesion = {miNavController.navigate(route = "feed"){
                            popUpTo(route = "login"){
                                inclusive = true

                            }
                        } }
                    )
                }
                composable(route = "register"){
                    FacebookRegisterScreen(onClickBack = {
                        miNavController.popBackStack()
                    })
                }
                composable(route = "feed"){
                    FeedScreen()
                }
            }


        }
    }
}

