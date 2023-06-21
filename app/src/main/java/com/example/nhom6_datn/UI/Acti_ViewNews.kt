package com.example.nhom6_datn.UI
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nhom6_datn.R
import com.example.nhom6_datn.databinding.ActivityActiViewNewsBinding
import com.example.nhom6_datn.util.shower
import com.facebook.shimmer.ShimmerFrameLayout

class Acti_ViewNews : AppCompatActivity() {


    private lateinit var recyclerView : RecyclerView
    private lateinit var manager : LinearLayoutManager
    private lateinit var shimmerFrameLayout: ShimmerFrameLayout


    private lateinit var binding:ActivityActiViewNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acti_view_news)
        binding=ActivityActiViewNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageSlide = binding.ActiViewNewsImageSlider
        val intent = intent
        val bundle = intent.extras ?: return

        val title = binding.ActiViewNewsTitle
        val message = binding.ActiViewNewsMessage
        val date = binding.ActiViewNewsDate


        val inputComment = binding.ActiViewNewsInputComment
        val buttonComment = binding.ActiViewNewsButtonComment
        buttonComment.setOnClickListener {
            val _inputComment = inputComment.editText?.text.toString().trim()
            if (_inputComment.isEmpty()){
                Toast(this).shower(getString(R.string.ERROR),0,this)
                return@setOnClickListener
            }else{

            }
        }
         recyclerView = binding.ActiViewNewsRecyclerView
         manager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        recyclerView.layoutManager = manager

        shimmerFrameLayout = binding.ActiViewNewsShimmerFrameLayout

    }

}