package com.ajailani.kmpexample.ui.screen.cat_list

import com.ajailani.kmpexample.data.model.Cat

data class CatListUiState(
    val isLoading: Boolean = false,
    val cats: List<Cat> = emptyList(),
    val errorMessage: String? = null
)
