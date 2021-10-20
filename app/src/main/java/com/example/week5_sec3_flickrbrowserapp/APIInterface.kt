package com.example.week5_sec3_flickrbrowserapp

import retrofit2.Call
import retrofit2.http.PUT
import retrofit2.http.Query

interface APIInterface {
   @PUT("/services/rest/")
    fun getAllPhotos(
       @Query("tags")tags:String ,// from User
       @Query("method")method:String?="flickr.photos.search",
       @Query("api_key")api_key:String?="e172f6ca4a9221f504c73d04194db61d",
       @Query("per_page")per_page:String?="100",
       @Query("format")format:String?="json",
       @Query("nojsoncallback")nojsoncallback:String?="1"

    ): Call<Flickr_j>


}