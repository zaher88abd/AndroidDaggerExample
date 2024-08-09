package dev.zaherabd.daggerexample.mainactivity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dev.zaherabd.daggerexample.R
import dev.zaherabd.daggerexample.databinding.ActivityMainBinding
import dev.zaherabd.daggerexample.model.RecyclerList

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    private lateinit var repoRCViewAdapter: RepoRCVAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        initRecyclerview()
        initViewModel()
    }

    private fun initRecyclerview() {
        bind.repoRCListView.layoutManager = LinearLayoutManager(this)
        repoRCViewAdapter = RepoRCVAdapter()
        bind.repoRCListView.adapter = repoRCViewAdapter
    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class)
        mainActivityViewModel.getLiveDataObserver().observe(this, object : Observer<RecyclerList?> {
            override fun onChanged(value: RecyclerList?) {
                if (value?.item != null) {
                    repoRCViewAdapter.setUpdateData(value.item)
                    repoRCViewAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(this@MainActivity, "Error getting data", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
        mainActivityViewModel.makeApiCall()
    }
}