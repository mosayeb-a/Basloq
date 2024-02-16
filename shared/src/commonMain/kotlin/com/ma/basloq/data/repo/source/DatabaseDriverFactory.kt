package com.ma.basloq.data.repo.source

import com.ma.basloq.database.BasloqDatabase
import com.squareup.sqldelight.ColumnAdapter
import com.squareup.sqldelight.db.SqlDriver


expect class DatabaseDriverFactory {
    fun create(): SqlDriver
}


class BasloqDatabaseFactory(
    private val driver: DatabaseDriverFactory
) {
    fun createDatabase(): BasloqDatabase {
        return BasloqDatabase(
            driver = driver.create(),
            quotesAdapter = Quotes.Adapter(
                tagsAdapter = StringListColumnAdapter
            )
        )
    }
}