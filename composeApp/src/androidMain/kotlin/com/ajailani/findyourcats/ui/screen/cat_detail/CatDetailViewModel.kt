package com.ajailani.findyourcats.ui.screen.cat_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.ajailani.findyourcats.data.repository.CatRepository
import com.ajailani.findyourcats.ui.navigation.route.CatDetailRoute
import com.ajailani.findyourcats.util.ApiResult
import kotlinx.coroutines.launch

class CatDetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val catRepository: CatRepository
) : ViewModel() {
    private val route = savedStateHandle.toRoute<CatDetailRoute>()

    var uiState by mutableStateOf(CatDetailUiState())
        private set

    init {
        getCatDetail()
    }

    private fun getCatDetail() {
        uiState = uiState.copy(isLoading = true)

        viewModelScope.launch {
            catRepository.getCatDetail(route.name).collect {
                uiState = when (it) {
                    is ApiResult.Success -> {
                        uiState.copy(
                            isLoading = false,
                            cat = it.data
                        )
                    }

                    is ApiResult.Error -> {
                        uiState.copy(
                            isLoading = false,
                            errorMessage = it.message
                        )
                    }
                }
            }
        }
    }
}