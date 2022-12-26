package com.example.hashcode.domain

import com.example.hashcode.domain.converter.RestaurantStringConverter
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Destination(
    @Id @GeneratedValue
    val id: Long? = null,
    val name: String,
    @Convert(converter = RestaurantStringConverter::class)
    val restaurants: List<Restaurant> = emptyList()
)