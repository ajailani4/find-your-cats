package com.ajailani.findyourcats.util

sealed interface CatAttributeType {
    data class Text(val text: String) : CatAttributeType
    data class Rating(val rating: Int) : CatAttributeType
}