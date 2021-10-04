package me.alekseinovikov.home.bot.hometelegrambot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HomeTelegramBotApplication

fun main(args: Array<String>) {
    runApplication<HomeTelegramBotApplication>(*args)
}
