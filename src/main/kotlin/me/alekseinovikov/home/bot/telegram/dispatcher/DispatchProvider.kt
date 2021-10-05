package me.alekseinovikov.home.bot.telegram.dispatcher

import com.github.kotlintelegrambot.dispatcher.Dispatcher

interface DispatchProvider {
    fun provide(): Dispatcher.() -> Unit
}