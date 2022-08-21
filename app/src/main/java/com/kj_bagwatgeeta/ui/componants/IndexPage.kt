package com.kj_bagwatgeeta.ui.componants

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kj_bagwatgeeta.model.resmodel.ChapterRes
import com.kj_bagwatgeeta.ui.componants.viewmodel.MyViewModel
import com.kj_bagwatgeeta.ui.customviews.CustomLoader
import com.kj_bagwatgeeta.ui.customviews.Header
import com.kj_bagwatgeeta.ui.theme.*
import com.kj_bagwatgeeta.utils.pageVersesList

@Composable
fun Index(myViewModel: MyViewModel, navController: NavController) {
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
        topBar = { Header(navController, scope, "Chapters", false) },
        content = { Indexdata(myViewModel, context, navController) },
    )
}


@Composable
fun Indexdata(myViewModel: MyViewModel, context: Context, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        //--------indexList---------------------------------
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 5.dp),
        ) {
            items(myViewModel.allChapters.size) { pos ->
                IndexItem(
                    myViewModel.allChapters[pos],
                    myViewModel,
                    context,
                    navController
                )
            }
        }
        //-----------end of userlist------------

    }

}

@Composable
fun IndexItem(
    data: ChapterRes,
    myViewModel: MyViewModel,
    context: Context,
    navController: NavController
) {
    Spacer(modifier = Modifier.height(20.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = ORANGE, shape = RoundedCornerShape(size = 15.dp))
            .clickable {
                myViewModel.getAllVersesOfChapter(context, data.id ?: 0)
                navController.navigate(pageVersesList)
            }
            .border(width = 2.dp, color = Yellow500, shape = RoundedCornerShape(size = 15.dp))
    ) {
        Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp)) {
            Text(
                text = "${data.chapterNumber ?: "1"}. ${data.name ?: ""}",
                color = White,
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
                maxLines = 1,
                fontFamily = FontFamily.SansSerif
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = data.nameMeaning ?: "",
                color = White,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                maxLines = 1,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IndexPreview() {
    androidx.compose.material.Surface(modifier = Modifier.fillMaxSize()) {
        Index(myViewModel = MyViewModel(), navController = rememberNavController())
    }


}