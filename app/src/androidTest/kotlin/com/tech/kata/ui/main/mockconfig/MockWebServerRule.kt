package com.tech.kata.ui.main.mockconfig

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockWebServer
import org.junit.rules.ExternalResource
import java.io.IOException

class MockWebServerRule: ExternalResource() {

    private  lateinit var mockWebServer: MockWebServer
    private  lateinit var dispatcher: Dispatcher

    fun getDispatcher(): Dispatcher {
        return dispatcher
    }

    fun getMockWebServer(): MockWebServer {
        return mockWebServer
    }

    @Throws(IOException::class)
    override fun before() {
        mockWebServer = MockWebServer()
        dispatcher =  MockResponseDispatcher()
        mockWebServer.dispatcher = dispatcher
        mockWebServer.start(8081)
    }

    override fun after() {
        try {
            mockWebServer.shutdown()
            dispatcher.shutdown()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}

