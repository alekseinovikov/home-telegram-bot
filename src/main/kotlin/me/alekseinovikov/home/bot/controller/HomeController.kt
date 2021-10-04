package me.alekseinovikov.home.bot.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController {

    @RequestMapping(value = ["/", "/index", "index.html"])
    fun index(): String = "index"

}