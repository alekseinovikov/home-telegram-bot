package me.alekseinovikov.home.bot.service.grocery.list

import com.github.kotlintelegrambot.entities.User
import me.alekseinovikov.home.bot.service.FunctionalService
import me.alekseinovikov.home.bot.service.MarkdownTextMessage
import me.alekseinovikov.home.bot.service.Message
import me.alekseinovikov.home.bot.service.ServiceTypes
import org.springframework.stereotype.Service

@Service
class GroceryListService : FunctionalService {
    override val type = ServiceTypes.GROCERY_LIST

    override fun start(chatId: Long, user: User): Message {
        return MarkdownTextMessage(
            text = "Вы можете просмотреть или создать новый список покупок\\.",
            chatId
        )
    }

}