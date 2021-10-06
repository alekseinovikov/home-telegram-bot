package me.alekseinovikov.home.bot.service

import com.github.kotlintelegrambot.entities.User
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton

interface FunctionalServiceManager {
    val services: List<FunctionalService>
    fun getByTypeName(typeName: String): FunctionalService?
}

enum class ServiceTypes(val title: String) {
    GROCERY_LIST("Список покупок")
}

interface FunctionalService {
    val type: ServiceTypes
    fun start(chatId: Long, user: User): Message
}

sealed interface Message {
    val text: String
    val chatId: Long
}

data class InlineButtonsMessage(
    override val text: String,
    override val chatId: Long,
    val buttons: List<InlineKeyboardButton>
) : Message

data class MarkdownTextMessage(override val text: String,
                               override val chatId: Long) : Message