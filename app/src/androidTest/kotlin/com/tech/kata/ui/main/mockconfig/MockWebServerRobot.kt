package com.tech.kata.ui.main.mockconfig

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.QueueDispatcher
import okio.Buffer
import java.io.IOException

class MockWebServerRobot constructor(private val mockWebServer: MockWebServerRule) {

    private var rxIdlerController: RxIdlerController = RxIdlerController()

    @Throws(IOException::class)
    @JvmOverloads
    fun enqueueFromFile(relativePath: String, httpCode: Int = 200): MockWebServerRobot {
        val fileInputStream = javaClass.classLoader?.getResourceAsStream(relativePath)

        if (fileInputStream != null) {
            val mockResponse = MockResponse().setBody(Buffer().readFrom(fileInputStream))
            mockResponse.setResponseCode(httpCode)
            mockWebServer.getMockWebServer().enqueue(mockResponse)
        }
        return this
    }

    fun enqueueServerError(): MockWebServerRobot {
        val mockResponse = MockResponse().setHttp2ErrorCode(500)
        mockWebServer.getMockWebServer().enqueue(mockResponse)
        return this
    }

    fun enqueue(mockResponse: MockResponse): MockWebServerRobot {
        mockWebServer.getMockWebServer().enqueue(mockResponse)
        return this
    }

    fun useQueueDispatcher(): MockWebServerRobot {
        mockWebServer.getMockWebServer().dispatcher = QueueDispatcher()
        return this
    }

    fun useDefaultDispatcher(): MockWebServerRobot {
        mockWebServer.getMockWebServer().dispatcher = mockWebServer.getDispatcher()
        return this
    }

    fun performNoSyncAction(userActionToPerform: UserAction): MockWebServerRobot {
        disableNetworkSync()
        try {
            userActionToPerform.perform()
        } catch (e: Exception) {
            throw e
        } finally {
            enableNetworkSync()
        }

        return this
    }

    private fun disableNetworkSync() {
        if (!RxIdlerController.isInitialized) {
            throw RuntimeException(
                "No idling resources found - method is called before rxIdler was initialized \n" + "Make sure to call RxIdler.initialize() or use initialSyncAction() if schedulers are not yet created¬"
            )
        }
        rxIdlerController.unregisterAll()
    }

    private fun enableNetworkSync() {
        rxIdlerController.reRegisterAll()
    }
}
