package com.example.hashcode

import com.example.hashcode.domain.Destination
import com.example.hashcode.domain.Restaurant
import com.example.hashcode.repository.DestinationRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DestinationTest @Autowired constructor(
    private var destinationRepository: DestinationRepository
) {
    @Test
    fun `여행_목적지_생성`() {
        val destination = Destination(
            name = "오사카",
            restaurants = listOf(Restaurant(name = "이치란 라멘"))
        )
        val save = destinationRepository.save(destination)
    }
}