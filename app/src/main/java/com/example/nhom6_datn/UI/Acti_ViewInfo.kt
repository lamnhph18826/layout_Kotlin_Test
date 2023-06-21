package com.example.nhom6_datn.UI


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.nhom6_datn.R
import com.example.nhom6_datn.databinding.ActivityActiViewInfoBinding


class Acti_ViewInfo : AppCompatActivity() {
    private lateinit var name:TextView
    private lateinit var age:TextView
    private lateinit var address:TextView
    private lateinit var phone:TextView
    private lateinit var cccd:TextView
    private lateinit var binding:ActivityActiViewInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acti_view_info)
        binding = ActivityActiViewInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}