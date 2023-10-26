package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        ImagesViewModel.setImages(imageArray)

        // Attach an instance of ImageDisplayFragment using factory method
        val imageDisplayFragment = ImageDisplayFragment.newInstance(imageArray)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, imageDisplayFragment)
            .commit()

        val imagesViewModel = ViewModelProvider(this)[ImagesViewModel::class.java]
    }
}
