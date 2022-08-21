package com.kj_bagwatgeeta.ui.componants

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kj_bagwatgeeta.R
import com.kj_bagwatgeeta.ui.componants.viewmodel.MyViewModel
import com.kj_bagwatgeeta.ui.customviews.CustomLoader
import com.kj_bagwatgeeta.utils.pageIndex
import com.kj_bagwatgeeta.utils.pageSplash
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime


@OptIn(ExperimentalTime::class)
@Composable
fun Splash(myViewModel: MyViewModel, navController: NavHostController) {
    val context = LocalContext.current
    if (myViewModel.showLoader.value) {
        CustomLoader(setShowLoading = { myViewModel.showLoader.value = it })
    }
    LaunchedEffect(Unit) {
       delay(4.seconds)
        myViewModel.getAllChapter(context)
        navController.navigate(pageIndex){
            popUpTo(pageSplash)
        }

    }


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painterResource(id = R.drawable.splash_logo),
            contentDescription = "",
            modifier = Modifier
                .align(alignment = Alignment.Center)
                , contentScale = ContentScale.FillBounds
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    androidx.compose.material.Surface(modifier = Modifier.fillMaxSize()) {
        Splash(myViewModel = MyViewModel(), navController = rememberNavController())
    }


}