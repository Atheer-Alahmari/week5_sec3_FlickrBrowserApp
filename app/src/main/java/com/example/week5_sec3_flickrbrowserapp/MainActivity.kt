package com.example.week5_sec3_flickrbrowserapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rec_View: RecyclerView
    private val apiInterface by lazy { APIClint().getClient()?.create(APIInterface::class.java) }

    //private lateinit var progressDialog: ProgressDialog
    private lateinit var btnSearch: Button
    private lateinit var etSearch: EditText
    var photoList = ArrayList<Photo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rec_View = findViewById(R.id.recycler_View)
        btnSearch = findViewById(R.id.btn_search)
        etSearch = findViewById(R.id.search_ED)

        btnSearch.setOnClickListener {
            var tag = etSearch.text.toString()
            getAllPhotos(tag)
           etSearch.text.clear()
            photoList.clear()
        }
    }

    private fun getAllPhotos(tags: String) {
        apiInterface?.getAllPhotos(tags)?.enqueue(object : Callback<Flickr_j?>{
            override fun onResponse(
                call: Call<Flickr_j?>,
                response: Response<Flickr_j?>
            ) {
                val resource = response.body()!!.photos.photo
                for (datum in resource) {
                    photoList.add(datum)
                }

               // rec_View.adapter?.notifyDataSetChanged() normal onec
                rec_View.adapter=RVAdapter(photoList,this@MainActivity)//to view photo full screen
                rec_View.layoutManager=LinearLayoutManager(this@MainActivity)

               // progressDialog.dismiss()
            }


            override fun onFailure(call: Call<Flickr_j?>, t: Throwable) {
               // progressDialog.dismiss()
                Toast.makeText(this@MainActivity, "Unable to get photo", Toast.LENGTH_LONG).show()
            }
        })

    }
}

