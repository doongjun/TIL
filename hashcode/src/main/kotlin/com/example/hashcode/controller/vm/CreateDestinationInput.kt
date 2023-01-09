package com.example.hashcode.controller.vm

import com.example.hashcode.domain.Restaurant
import org.jetbrains.annotations.NotNull

data class CreateDestinationInput(
    @field:NotNull
    val name: String,
    val restaurants: List<Restaurant> = emptyList()
)
