package com.example.newsinshort.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.internetmodule.ResourceState
import com.example.newsinshort.data.entity.NewsResponse
import com.example.newsinshort.ui.components.Loader
import com.example.newsinshort.ui.components.NewsRowComponent
import com.example.newsinshort.ui.viewmodel.NewsViewModel

const val TAG = "HomeScreen"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val pager = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        100
    }
    val newsUiState by newsViewModel.news.collectAsState()

    VerticalPager(
        state = pager,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { pageIndex: Int ->
        when (newsUiState) {
            is ResourceState.Loading -> {
                Loader()
            }

            is ResourceState.Success -> {
                val response = (newsUiState as ResourceState.Success<NewsResponse>).data
                if (response.articles.isNotEmpty()) {
                    NewsRowComponent(pageIndex, response.articles[pageIndex])
                }else{

                    Column {
                        Text(text = "no articles found", modifier = modifier.align(Alignment.CenterHorizontally))
                    }
                }
                Log.e(TAG, "HomeScreen: ${response.totalResults}")

            }

            is ResourceState.Error -> {
                val errorMessage = (newsUiState as ResourceState.Error).message
                Log.e(TAG, "HomeScreen: $errorMessage")
            }

        }

    }


}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}