package com.ajailani.findyourcats.ui.screen.cat_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ajailani.findyourcats.R
import com.ajailani.findyourcats.ui.common.component.CatAttribute
import com.ajailani.findyourcats.util.CatAttributeType.Rating
import com.ajailani.findyourcats.util.CatAttributeType.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatDetailScreen(
    uiState: CatDetailUiState,
    onNavigateUp: () -> Unit
) = with(uiState) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Detail")
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateUp) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back icon"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        when {
            isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            cat != null -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(innerPadding)
                        .padding(20.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .size(250.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            model = cat.imageLink,
                            placeholder = painterResource(id = R.drawable.ic_launcher_background),
                            contentScale = ContentScale.Crop,
                            contentDescription = "Cat image"
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Cat Name",
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        CatAttribute(key = "Origin", value = Text(cat.origin))
                        CatAttribute(key = "Length", value = Text(cat.length))
                        CatAttribute(key = "Family Friendly", value = Rating(cat.familyFriendlyRating))
                        CatAttribute(key = "General Health", value = Rating(cat.generalHealthRating))
                        CatAttribute(key = "Grooming", value = Rating(cat.groomingRating))
                    }
                }
            }
        }
    }
}