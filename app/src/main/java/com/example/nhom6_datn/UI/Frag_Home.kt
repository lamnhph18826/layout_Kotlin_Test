package com.example.nhom6_datn.UI

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nhom6_datn.R
import com.example.nhom6_datn.UI.Manager.Acti_Manager
import com.example.nhom6_datn.UI.Manager.Acti_Statistical
import com.example.nhom6_datn.util.shower
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class Frag_Home : Fragment() {
    private lateinit var manager:Button
    private lateinit var imgNews:Button
    private lateinit var statistical:Button
    private lateinit var linearLayoutManager:LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var shimmerFrameLayout: ShimmerFrameLayout


    private var TAG:String="Frag_Home"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_frag__home, container, false)

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.Frag_Home_helloProfile)
        val imgSky = view.findViewById<ImageView>(R.id.Frag_Home_imgSky)
        val nameMember = view.findViewById<TextView>(R.id.Frag_Home_nameProFile)



        checkDate(textView,imgSky)
        call(view)

        imgNews.setOnClickListener {
           Toast(context).shower("Update "+getString(R.string.successful),10, context as Activity)
            startActivity(Intent(context,Acti_News::class.java))
        }
        manager.setOnClickListener {
            startActivity(Intent(context,Acti_Manager::class.java))
        }
        statistical.setOnClickListener {
            startActivity(Intent(context,Acti_Statistical::class.java))
        }



    }
    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    private fun checkDate(textView: TextView,imageView: ImageView){
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val time = SimpleDateFormat("HH")
        val currentDate = time.format(Date())
        when(currentDate.toInt()){
            in 0..10 ->textView.text=getString(R.string.hello_Profile_AM)
            in 11..18 -> {
                textView.text=getString(R.string.hello_Profile_CM)
                imageView.setImageResource(R.drawable.sky_cm)
            }
            else -> {
                textView.text=getString(R.string.hello_Profile_PM)
                imageView.setImageResource(R.drawable.sky_pm)
            }
        }
    }
    private fun call(view: View){
        manager = view.findViewById(R.id.Frag_home_Manager)
        imgNews = view.findViewById(R.id.Frag_news)
        statistical = view.findViewById(R.id.Frag_home_statistical)
        linearLayoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        recyclerView= view.findViewById(R.id.RecyclerView)
        recyclerView.layoutManager = linearLayoutManager
        shimmerFrameLayout = view.findViewById(R.id.Frag_home_ShimmerFrameLayout)
    }

}