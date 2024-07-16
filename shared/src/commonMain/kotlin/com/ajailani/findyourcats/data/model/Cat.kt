package com.ajailani.findyourcats.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    val name: String,
    @SerialName("image_link")
    val imageLink: String,
    val length: String,
    val origin: String,
    @SerialName("family_friendly")
    val familyFriendlyRating: Int,
    @SerialName("general_health")
    val generalHealthRating: Int,
    @SerialName("grooming")
    val groomingRating: Int
)