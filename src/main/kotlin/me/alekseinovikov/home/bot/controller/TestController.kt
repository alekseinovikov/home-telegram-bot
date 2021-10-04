package me.alekseinovikov.home.bot.controller

import me.alekseinovikov.home.bot.repo.TestRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/test")
class TestController(private val testRepository: TestRepository) {

    @PostMapping
    suspend fun create(@RequestBody name: String): Long =
        testRepository.add(name)

    @GetMapping("/{id}")
    suspend fun get(@PathVariable id: Long): ResponseEntity<String> =
        testRepository.get(id)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

}