package com.ajailani.findyourcats.ui.screen.cat_list

import com.ajailani.findyourcats.data.model.Cat

data class CatListUiState(
    val isLoading: Boolean = false,
    val cats: List<Cat> = emptyList(),
    val errorMessage: String? = null
)
