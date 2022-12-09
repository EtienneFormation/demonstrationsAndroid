package eni.testskotlin.rest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import eni.testskotlin.R
import eni.testskotlin.databinding.ActivityRestBinding
import eni.testskotlin.rest.bo.Beer
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class RestActivity : AppCompatActivity() {
    private val beer = MutableLiveData<Beer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityRestBinding>(this, R.layout.activity_rest)
        binding.lifecycleOwner = this
        beer.observe(this) { binding.beer = it }
        binding.btnRefresh.setOnClickListener{ refresh() }
        refresh()
    }

    private fun refresh() {
        val clientOKHttp = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.punkapi.com/v2/beers/random")
            .build()
        clientOKHttp.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Pouet", "onFailure: " + e.message, )
            }

            override fun onResponse(call: Call, response: Response) {
                if(response.isSuccessful){
                    val jsonString = response.body?.string()
                    val arrayBeer = JSONArray(jsonString)
                    for (i in 0 until arrayBeer.length()) {
                        val cur = arrayBeer[i] as JSONObject
                        beer.postValue(Beer(cur.getString("id"), cur.getString("name"), cur.getString("description")))
                    }
                }
            }
        })
    }
}