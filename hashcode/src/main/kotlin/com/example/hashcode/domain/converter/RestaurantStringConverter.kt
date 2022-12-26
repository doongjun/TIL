package com.example.hashcode.domain.converter

import com.example.hashcode.domain.Restaurant
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class RestaurantStringConverter: AttributeConverter<List<Restaurant>, String> {
    override fun convertToDatabaseColumn(attribute: List<Restaurant>): String {
        return ObjectMapper().writeValueAsString(attribute)
    }

    override fun convertToEntityAttribute(dbData: String?): List<Restaurant> {
        val typeReference = object : TypeReference<List<Restaurant>>() {}
        return ObjectMapper().readValue(dbData, typeReference)
    }
}