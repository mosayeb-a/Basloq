package com.ma.basloq.data.repo.source

import com.ma.basloq.database.BasloqDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun  create (): SqlDriver =
        NativeSqliteDriver(BasloqDatabase.Schema,"basloq.db")
}