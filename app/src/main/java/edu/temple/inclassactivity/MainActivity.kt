package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var someVar: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //  if (::someVar.isInitialized)


        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) { typedArray.getResourceId(it, 0) }
        //typedArray.recycle()

        // Attach an instance of ImageDisplayFragment using factory method
        val imageDisplayFragment = ImageDisplayFragment.newInstance(imageArray)
        /*
       // if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) !is ImageDisplayFragment)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, imageDisplayFragment)
            //.remove(ImageDisplayFragment())
            .addToBackStack(null)
            .setReorderingAllowed(true)
            .commit()

    } */
    }

    fun setImages(_images: IntArray) {
        images = _images
        ( view as RecyclerView).adapter = CustomRecyclerAdapter.images
    }
}

