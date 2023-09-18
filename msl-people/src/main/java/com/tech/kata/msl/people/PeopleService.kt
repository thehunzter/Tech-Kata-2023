package com.tech.kata.msl.people


import io.reactivex.Observable
import retrofit2.http.GET


interface PeopleService {

  @GET("/api/people")
  fun getPeople(): Observable<PeopleResponse>
}
