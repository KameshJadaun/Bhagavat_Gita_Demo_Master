package com.kj_bagwatgeeta.ui.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kj_bagwatgeeta.model.resmodel.ChapterRes
import com.kj_bagwatgeeta.model.resmodel.VersesRes
import com.kj_bagwatgeeta.ui.componants.viewmodel.MyViewModel
import com.kj_bagwatgeeta.ui.customviews.CustomLoader
import com.kj_bagwatgeeta.ui.customviews.Header
import com.kj_bagwatgeeta.ui.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun VersesList(myViewModel: MyViewModel, navController: NavController) {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    if (myViewModel.showLoader.value) {
        CustomLoader(setShowLoading = { myViewModel.showLoader.value = it })
    }
//---------------------------------------UI-----------------------

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxWidth(),
        topBar = { Header(navController, scope,"Verses",true) },
        content = { VersesData(myViewModel) },
    )
}


@Composable
fun VersesData(myViewModel: MyViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        //--------indexList---------------------------------
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 5.dp),
        ) {
            items(myViewModel.allVerses.size) { pos -> VersesItem(myViewModel.allVerses[pos]) }
        }
        //-----------end of userlist------------

    }

}

@Composable
fun VersesItem(data:VersesRes) {
    Spacer(modifier = Modifier.height(20.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = ORANGE, shape = RoundedCornerShape(size = 15.dp))

    ) {
        Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp)) {
            Text(
                text = "${data.text?:""}",
                color = White,
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily.SansSerif
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = data.transliteration?:"",
                color = White,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VersesListPreview() {
    androidx.compose.material.Surface(modifier = Modifier.fillMaxSize()) {
        Index(myViewModel = MyViewModel(), navController = rememberNavController())
    }


}