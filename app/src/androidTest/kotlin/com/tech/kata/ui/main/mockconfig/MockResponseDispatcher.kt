package com.tech.kata.ui.main.mockconfig

import android.os.Handler
import androidx.test.platform.app.InstrumentationRegistry
import com.tech.kata.ui.main.PeopleRecordedRequestHandler
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MockResponseDispatcher internal constructor() : Dispatcher() {

    private val airportHandler = AirportsRecordedRequestHandler()
    private val peopleHandler = PeopleRecordedRequestHandler()

    override fun dispatch(request: RecordedRequest): MockResponse {

        if (airportHandler.canHandleRequest(request)) {
            return airportHandler.getResponse(request)
        }

        if (peopleHandler.canHandleRequest(request)) {
            return peopleHandler.getResponse(request)
        }

        return throwUnsupportedException("Could not handle", request.path!!)
    }

    private fun throwUnsupportedException(message: String, path: String): MockResponse {
        val mainThreadHandler =
            Handler(InstrumentationRegistry.getInstrumentation().targetContext.mainLooper)
        mainThreadHandler.post { throw UnsupportedOperationException("$message $path") }

        throw UnsupportedOperationException()
    }

    companion object {

        private val ACCEPT_TYPE = "Accept"
        private val MSL_V1_JSON = "application/vnd.msl.v1+json"
        private val BAD_REQUEST = 400
    }
}
