package me.alekseinovikov.home.bot.telegram

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import me.alekseinovikov.home.bot.telegram.dispatcher.DispatchProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TelegramBotConfig {

    @Bean
    fun botBean(
        props: BotProperties,
        dispatchProvider: DispatchProvider
    ) = bot {
        token = props.token
        dispatch(dispatchProvider.provide())
    }

}