package com.example.imageviewer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImageViewer : AppCompatActivity() {
    private val images = listOf(
        R.drawable.image0,
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9
    )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_image_viewer)
        val imageView: ImageView = findViewById(R.id.imageView)
        val prevButton: Button = findViewById(R.id.prevButton)
        val nextButton: Button = findViewById(R.id.nextButton)

        imageView.setImageResource(images[currentIndex])

        prevButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                imageView.setImageResource(images[currentIndex])
                updateButtonStates(prevButton, nextButton)
            }
        }

        nextButton.setOnClickListener {
            if (currentIndex < images.size - 1) {
                currentIndex++
                imageView.setImageResource(images[currentIndex])
                updateButtonStates(prevButton, nextButton)
            }
        }

        // Initial button states
        updateButtonStates(prevButton, nextButton)
    }

    private fun updateButtonStates(prevButton: Button, nextButton: Button) {
        prevButton.isEnabled = currentIndex > 0
        nextButton.isEnabled = currentIndex < images.size - 1
    }
}
