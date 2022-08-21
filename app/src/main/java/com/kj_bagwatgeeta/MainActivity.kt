package com.kj_bagwatgeeta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kj_bagwatgeeta.ui.componants.Index
import com.kj_bagwatgeeta.ui.componants.Splash
import com.kj_bagwatgeeta.ui.componants.VersesList
import com.kj_bagwatgeeta.ui.componants.viewmodel.MyViewModel
import com.kj_bagwatgeeta.ui.theme.Jetpack_compose_practiceTheme
import com.kj_bagwatgeeta.utils.*

class MainActivity : ComponentActivity() {
    private var myViewModel: MyViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myViewModel = MyViewModel()
        setContent {
            Jetpack_compose_practiceTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = pageSplash) {
                    composable(route = pageSplash) {
                        Splash(myViewModel!!, navController)
                    }
                    composable(route = pageIndex) {
                        Index(myViewModel!!, navController)
                    }
                    composable(route = pageVersesList) {
                        VersesList(myViewModel!!, navController)
                    }
                    /*composable(route = "$pageHome?name={name},email={email}", arguments = listOf(navArgument(name = "name") {
                        type = NavType.StringType
                    }, navArgument(name = "email") {
                        type = NavType.StringType
                    })) {
                        HomePage(navController, homeViewModel!!)
                    }*/
                }

            }
        }
    }
}












