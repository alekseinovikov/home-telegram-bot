package me.alekseinovikov.home.bot.repo

import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.awaitOneOrNull
import org.springframework.r2dbc.core.awaitSingle
import org.springframework.stereotype.Repository

interface TestRepository {
    suspend fun add(name: String): Long
    suspend fun get(id: Long): String?
}

@Repository
class TestRepositoryImpl(private val db: DatabaseClient) : TestRepository {

    override suspend fun add(name: String): Long = db.sql(
        """
            INSERT INTO test(name) VALUES(:name) RETURNING id
        """.trimIndent()
    ).bind("name", name)
        .fetch()
        .awaitSingle()
        .values
        .first() as Long

    override suspend fun get(id: Long): String? = db.sql(
        """
            SELECT name FROM test WHERE id = :id
        """.trimIndent()
    ).bind("id", id)
        .fetch()
        .awaitOneOrNull()
        ?.values
        ?.first() as String?

}