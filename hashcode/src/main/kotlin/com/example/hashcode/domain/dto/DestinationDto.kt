package com.example.hashcode.domain.dto

import com.example.hashcode.domain.Destination
import com.example.hashcode.domain.Restaurant

data class DestinationDto(
    var id: Long? = null,
    var name: String,
    var restaurants: List<Restaurant> = emptyList()
) {
    constructor(destination: Destination): this(
        id = destination.id,
        name = destination.name,
        restaurants = destination.restaurants
    )

    fun toEntity(): Destination = Destination(id = id, name = name, restaurants = restaurants)
}