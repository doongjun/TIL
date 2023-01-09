package com.example.hashcode.service

import com.example.hashcode.repository.DestinationRepository
import com.example.hashcode.domain.dto.DestinationDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DestinationService(
    private val destinationRepository: DestinationRepository
) {
    fun getDestinations(): List<DestinationDto> = destinationRepository.findAll().map { DestinationDto(it) }

    fun findDestinationById(id: Long): DestinationDto? =
        destinationRepository.findById(id).orElse(null)?.let { DestinationDto(it) }

    fun createDestination(
        destinationDto: DestinationDto
    ): Long? {
        val destination = destinationDto.toEntity()
        val result = destinationRepository.save(destination)
        return result.id
    }
}