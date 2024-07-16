package com.ajailani.findyourcats.ui.screen.cat_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ajailani.findyourcats.ui.common.component.CatCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatListScreen(
    uiState: CatListUiState,
    onNavigateToCatDetail: (String) -> Unit
) = with(uiState) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(text = "Find Your Cats")
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(20.dp)
        ) {
            items(cats) {
                CatCard(
                    cat = it,
                    onClick = { onNavigateToCatDetail(it.name) }
                )

                if (it != cats.last()) {
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }

        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}