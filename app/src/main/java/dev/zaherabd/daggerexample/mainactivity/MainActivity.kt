package dev.zaherabd.daggerexample.mainactivity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dev.zaherabd.daggerexample.R
import dev.zaherabd.daggerexample.model.RecycleData
import dev.zaherabd.daggerexample.model.RecycleList
import kotlinx.android.synthetic.main.activity_main.repoRCListView

class MainActivity : AppCompatActivity() {

    private lateinit var repoRCViewAdapter: RepoRCVAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun initRecyclerview() {
        repoRCListView.layoutManager = LinearLayoutManager(this)
        repoRCViewAdapter = RepoRCVAdapter()
        repoRCListView.adapter = repoRCViewAdapter
    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class)
        mainActivityViewModel.getLiveDataObserver().observe(this, object : Observer<RecycleList?> {
            override fun onChanged(value: RecycleList?) {
                if (value != null) {
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