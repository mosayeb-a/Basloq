package com.ma.basloq.data.repo.source

import android.content.Context
import com.ma.basloq.database.BasloqDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun create(): SqlDriver =
        AndroidSqliteDriver(BasloqDatabase.Schema, context, "basloq.db")
}