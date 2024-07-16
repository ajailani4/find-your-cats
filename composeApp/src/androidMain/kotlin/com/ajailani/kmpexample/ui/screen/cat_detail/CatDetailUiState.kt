package com.ajailani.kmpexample.ui.screen.cat_detail

import com.ajailani.kmpexample.data.model.Cat

data class CatDetailUiState(
    val isLoading: Boolean = false,
    val cat: Cat? = null,
    val errorMessage: String? = null
)
