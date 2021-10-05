package me.alekseinovikov.home.bot.telegram

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "bot")
class BotProperties {
    lateinit var token: String
}