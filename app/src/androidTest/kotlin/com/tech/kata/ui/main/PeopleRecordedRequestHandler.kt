package com.tech.kata.ui.main

import com.tech.kata.ui.main.mockconfig.AirportsRecordedRequestHandler
import com.tech.kata.ui.main.mockconfig.RecordedRequestHandler
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class PeopleRecordedRequestHandler: RecordedRequestHandler() {

    override fun canHandleRequest(request: RecordedRequest): Boolean {
        return request.method == "GET" && request.path!!.contains(PEOPLE)
    }

    override fun getResponse(request: RecordedRequest): MockResponse {
        val body = readJsonFile("people/get_people.json")
        return getResponseWithBody(200, body)
    }


    companion object {

        private val PEOPLE = "/api/people"
    }
}