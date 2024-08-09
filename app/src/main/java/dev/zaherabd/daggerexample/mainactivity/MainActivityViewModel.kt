package dev.zaherabd.daggerexample.mainactivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import dev.zaherabd.daggerexample.di.RetroServiceInterface
import dev.zaherabd.daggerexample.model.RecycleData
import dev.zaherabd.daggerexample.model.RecycleList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    @Inject
    lateinit var mService: RetroServiceInterface

    private lateinit var liveDataList: MutableLiveData<RecycleList?>

    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<RecycleList?> {
        return liveDataList
    }

    fun makeApiCall() {
        val call: Call<RecycleList>? = mService.getDataFromAPI("atl")
        call?.enqueue(object : Callback<RecycleList> {
            override fun onResponse(call: Call<RecycleList>, response: Response<RecycleList>) {
                if (response.isSuccessful) {
                    liveDataList.postValue(response.body())
                } else {
                    liveDataList.postValue(null)
                }

            }

            override fun onFailure(call: Call<RecycleList>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}