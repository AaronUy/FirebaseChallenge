package com.example.android.firebasechallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.android.firebasechallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    fun createBlog(v: View){
        val intent = Intent(this, CreateActivity::class.java)
        startActivityForResult(intent, 1)
    }

    fun viewBlogs(v: View){

    }

    fun Exit(v: View){
        finish()
    }
}
