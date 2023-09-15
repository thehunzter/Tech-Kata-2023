package com.tech.kata.msl.people

import io.reactivex.Observable
import retrofit2.http.GET

interface PeopleService {

  @GET("people")
  fun getPeople(): Observable<PeopleResponse>
}
