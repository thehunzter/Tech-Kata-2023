package com.tech.kata.msl.people

import android.database.Observable
import retrofit2.http.GET


interface PeopleService {

  @GET
  fun getPeople(): Observable<PeopleResponse>
}
