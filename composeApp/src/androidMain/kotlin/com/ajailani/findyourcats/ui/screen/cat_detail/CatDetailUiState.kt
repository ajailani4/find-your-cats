package com.ajailani.findyourcats.ui.screen.cat_detail

import com.ajailani.findyourcats.data.model.Cat

data class CatDetailUiState(
    val isLoading: Boolean = false,
    val cat: Cat? = null,
    val errorMessage: String? = null
)
