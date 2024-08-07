package com.ajailani.findyourcats.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ajailani.findyourcats.ui.navigation.route.CatDetailRoute
import com.ajailani.findyourcats.ui.navigation.route.CatListRoute
import com.ajailani.findyourcats.ui.screen.cat_detail.CatDetailScreen
import com.ajailani.findyourcats.ui.screen.cat_detail.CatDetailViewModel
import com.ajailani.findyourcats.ui.screen.cat_list.CatListScreen
import com.ajailani.findyourcats.ui.screen.cat_list.CatListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = CatListRoute
    ) {
        composable<CatListRoute> {
            val viewModel = koinViewModel<CatListViewModel>()

            CatListScreen(
                uiState = viewModel.uiState,
                onNavigateToCatDetail = { id ->
                    navController.navigate(CatDetailRoute(id))
                }
            )
        }

        composable<CatDetailRoute> {
            val viewModel = koinViewModel<CatDetailViewModel>()

            CatDetailScreen(
                uiState = viewModel.uiState,
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}