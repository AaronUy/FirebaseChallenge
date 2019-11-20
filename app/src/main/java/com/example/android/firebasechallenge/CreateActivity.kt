package com.example.android.firebasechallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.android.firebasechallenge.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference

class CreateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var dbCateg: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_create)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create)

    }
}
