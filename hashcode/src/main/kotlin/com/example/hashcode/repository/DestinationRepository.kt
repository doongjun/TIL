package com.example.hashcode.repository

import com.example.hashcode.domain.Destination
import org.springframework.data.jpa.repository.JpaRepository

interface DestinationRepository: JpaRepository<Destination, Long>