package com.example.hashcode

import com.example.hashcode.domain.Destination
import com.example.hashcode.domain.Restaurant
import com.example.hashcode.repository.DestinationRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class DestinationTest @Autowired constructor(
    private var destinationRepository: DestinationRepository
) {
    @BeforeEach
    @Transactional
    fun init() {
        val destination1 = Destination(
            name = "일산",
            restaurants = listOf(
                Restaurant(name = "일산칼국수", street = "경의로 467"),
                Restaurant(name = "큐슈울트라아멘", street = "정발산로 43")
            )
        )

        val destination2 = Destination(
            name = "서울",
            restaurants = listOf(
                Restaurant(name = "포25", street = "퇴계로 85길"),
                Restaurant(name = "홍익돈까스", street = "북한산로 232")
            )
        )
        destinationRepository.saveAll(listOf(destination1, destination2))
    }

    @Test
    @Transactional
    fun `여행_목적지_조회`() {
        //given, when
        val findDestinations = destinationRepository.findAll()

        //then
        println()
    }
}