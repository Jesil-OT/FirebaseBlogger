package com.jesil.toborowei.learnfirestore.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jesil.toborowei.learnfirestore.R
import com.jesil.toborowei.learnfirestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}