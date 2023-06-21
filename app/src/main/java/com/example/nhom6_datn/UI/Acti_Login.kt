package com.example.nhom6_datn.UI
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import com.example.nhom6_datn.R;

import com.example.nhom6_datn.databinding.ActivityActiLoginBinding

class Acti_Login : AppCompatActivity() {
    private lateinit var binding: ActivityActiLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acti_login)
        binding = ActivityActiLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ani =AnimationUtils.loadAnimation(this,R.anim.fade_zoom).apply {
            duration = 2000
            interpolator = AccelerateDecelerateInterpolator()
        }

        checkGmail()
        checkPass()
        binding.ActiLoginAppCompatButton.setOnClickListener {
            var _gmail = binding.ActiLoginEmail.editText?.text.toString().trim()
            var _pass = binding.ActiLoginPassWord.editText?.text.toString().trim()
            var check=0

            if (_gmail.isEmpty()){
                binding.ActiLoginEmail.error = getString(R.string.ERROR)
            }else{
                check++
            }
            if (_pass.isEmpty()){
                binding.ActiLoginPassWord.error = getString(R.string.ERROR)
            }else{
                check++
            }

        }
    }

    private fun checkPass() {
        binding.ActiLoginPassWord.editText?.setOnFocusChangeListener { view, text ->
            if (!text){
                binding.ActiLoginPassWord.error = validate(binding.ActiLoginPassWord.editText!!.text.toString().trim())
            }
        }
    }

    private fun checkGmail(){
        binding.ActiLoginEmail.editText?.setOnFocusChangeListener { view, text ->
            if (!text){
                binding.ActiLoginEmail.error = validate(binding.ActiLoginEmail.editText!!.text.toString().trim())
            }
        }
    }

    private fun validate(text:String): String? {
        if(text.isEmpty()){
            return getString(R.string.ERROR)
        }
        return null
    }


}