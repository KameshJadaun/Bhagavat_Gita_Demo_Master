package com.kj_bagwatgeeta.ui.customviews

import android.opengl.Visibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kj_bagwatgeeta.ui.theme.White
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Header(navController: NavController, scope: CoroutineScope,title:String,showBack:Boolean?=false) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium, fontFamily = FontFamily.Default,
                modifier = Modifier.fillMaxWidth()
            )
        },

         navigationIcon = if(showBack==true){{

                 IconButton(onClick = {
                     scope.launch { navController.popBackStack() }

                 }) {
                     Icon(Icons.Default.ArrowBack, "backIcon")
                 }
             }
         }else null,
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = White,
        elevation = 10.dp
    )

}