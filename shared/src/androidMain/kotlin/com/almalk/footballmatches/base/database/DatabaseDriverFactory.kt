package com.almalk.footballmatches.base.database

import android.content.Context
import com.almalk.footballmatches.base.utils.Constants
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(AppDatabase.Schema, context, Constants.DATABASE_NAME)
    }
}