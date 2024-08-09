package dev.zaherabd.daggerexample.mainactivity

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import dev.zaherabd.daggerexample.MyApplication
import dev.zaherabd.daggerexample.di.RetroServiceInterface
import dev.zaherabd.daggerexample.model.RecyclerList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    @Inject
    lateinit var mService: RetroServiceInterface

    private lateinit var liveDataList: MutableLiveData<RecyclerList?>

    init {
        (application as MyApplication).getRetroComponent().inject(this)
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<RecyclerList?> {
        return liveDataList
    }

    fun makeApiCall() {
        val call: Call<RecyclerList>? = mService.getDataFromAPI("zaher")
        call?.enqueue(object : Callback<RecyclerList> {
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if (response.isSuccessful) {
                    Log.d("TESTCode", "onResponse: ${response.body()}")
                    liveDataList.postValue(response.body())
                } else {
                    liveDataList.postValue(null)
                }

            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}