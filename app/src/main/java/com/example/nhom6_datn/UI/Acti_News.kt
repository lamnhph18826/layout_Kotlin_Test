package com.example.nhom6_datn.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.nhom6_datn.MainActivity
import com.example.nhom6_datn.R
import com.example.nhom6_datn.databinding.ActivityActiNewsBinding
import com.facebook.shimmer.ShimmerFrameLayout

class Acti_News : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: LinearLayoutManager
    private lateinit var binding: ActivityActiNewsBinding
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var shimmerFrameLayout: ShimmerFrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acti_news)
        binding= ActivityActiNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //return main
        val returnMain = binding.ActiNewsReturn
        returnMain.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        //searhView
        val search = binding.ActiNewsSearchView
        search.clearFocus()
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return  false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
        shimmerFrameLayout = binding.ActiNewsShimmerFrameLayout
        recyclerView= binding.ActiNewsRecyclerView
        manager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        recyclerView.layoutManager = manager
        recyclerView.setHasFixedSize(true)
        //f5
        swipeRefreshLayout = binding.ActiNewsSwipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener {
            Handler(Looper.getMainLooper()).postDelayed({

                swipeRefreshLayout.isRefreshing= false
              },5000)
        }
    }
}