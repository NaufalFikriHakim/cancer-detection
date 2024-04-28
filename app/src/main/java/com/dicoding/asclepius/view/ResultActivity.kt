package com.dicoding.asclepius.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dicoding.asclepius.R
import com.dicoding.asclepius.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
        val prediction = intent.getStringExtra(EXTRA_PREDICTIONS)

        val imageUri = if (!imageUriString.isNullOrEmpty()) Uri.parse(imageUriString) else null
        Log.d("ResultAct", "showImage: $imageUri")
        Log.d("ResultAct", "onResults: $prediction")
        binding.resultImage.setImageURI(imageUri)
        binding.resultText.text = prediction
    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_PREDICTIONS = "extra_predictions"
    }


}