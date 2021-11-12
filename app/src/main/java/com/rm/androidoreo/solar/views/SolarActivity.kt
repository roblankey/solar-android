package com.rm.androidoreo.solar.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rm.androidoreo.databinding.ActivitySolarBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SolarActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySolarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySolarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
