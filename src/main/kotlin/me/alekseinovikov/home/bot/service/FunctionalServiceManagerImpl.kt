package me.alekseinovikov.home.bot.service

import org.springframework.stereotype.Service

@Service
class FunctionalServiceManagerImpl(override val services: List<FunctionalService>) : FunctionalServiceManager {

    private val serviceTypeNameToInstance by lazy { services.associateBy { it.type } }

    override fun getByTypeName(typeName: String): FunctionalService? = serviceTypeNameToInstance[ServiceTypes.valueOf(typeName)]

}