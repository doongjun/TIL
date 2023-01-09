package com.example.hashcode.controller

import com.example.hashcode.controller.vm.CreateDestinationInput
import com.example.hashcode.domain.dto.DestinationDto
import com.example.hashcode.service.DestinationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/destination")
class DestinationController(
    private val destinationService: DestinationService
) {
    @GetMapping
    fun getDestinations(): List<DestinationDto> = destinationService.getDestinations()

    @GetMapping("{id}")
    fun getDestinationById(
        @PathVariable id: Long
    ): ResponseEntity<DestinationDto?> = ResponseEntity.ok(destinationService.findDestinationById(id))

    @PostMapping
    fun createDestination(
        @RequestBody input: CreateDestinationInput
    ): ResponseEntity<DestinationDto?> {
        val resultId = destinationService.createDestination(
            DestinationDto(
                name = input.name,
                restaurants = input.restaurants
            )
        )
        val result = resultId?.let { destinationService.findDestinationById(it) }
        return ResponseEntity.ok(result)
    }
}