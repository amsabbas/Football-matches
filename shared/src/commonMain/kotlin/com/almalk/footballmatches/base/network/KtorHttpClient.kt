package com.almalk.footballmatches.base.network


import com.almalk.footballmatches.base.utils.*
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.observer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.utils.io.errors.*
import kotlinx.serialization.json.Json

class KtorHttpClient {
    val httpClient = HttpClient {

        val log = getLogger()

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 15000L
            connectTimeoutMillis = 15000L
            socketTimeoutMillis = 15000L
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    log.print(message)
                }
            }
            level = LogLevel.ALL
        }

        install(ResponseObserver) {
            onResponse { response ->
                log.print("${response.status.value}")
            }
        }

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            header("X-Auth-Token", Constants.AUTH_TOKEN)
        }


        HttpResponseValidator {
            validateResponse { response: HttpResponse ->
                val statusCode = response.status.value

                if (statusCode >= 300) {
                    throw AppException(
                        exceptionType = if (statusCode == 401)
                            AppExceptionType.UnAuthorized else AppExceptionType.API,
                    )
                }
            }

            handleResponseExceptionWithRequest { exception, _ ->
                val result = if (exception is IOException) {
                    AppException(AppExceptionType.Network, "", "", exception)
                } else {
                    exception.toAppException()
                }
                throw result
            }

        }


    }
}