package com.almalk.footballmatches.base.database

import com.almalk.footballmatches.base.utils.Constants
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, Constants.DATABASE_NAME)
    }
}