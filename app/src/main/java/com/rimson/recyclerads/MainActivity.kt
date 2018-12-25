package com.rimson.recyclerads

import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.rimson.recyclerads.view.RecyclerImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var base = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val top = BitmapFactory.decodeResource(resources, R.mipmap.top)
        val bottom = BitmapFactory.decodeResource(resources, R.mipmap.bottom)
        recycler_ad.setImageBitmap(bottom, top)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            val screenHeight = this.window.decorView.height
            val blankHeight = blank_view_1.height
            val imageHeight = recycler_ad.height
            base = blankHeight + imageHeight - screenHeight
            Log.d("hehe", "s:" + screenHeight.toString())
            Log.d("hehe", "b:" + blankHeight.toString())
            Log.d("hehe", "i:" + imageHeight.toString())
            Log.d("hehe", "base:" + base.toString())

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                scrollView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
                    Log.d("hehe", "scrollY:" + scrollY.toString())
                    Log.d("hehe", "base:" + base.toString())
                    when {
                        scrollY > blankHeight -> recycler_ad.updateCenter(RecyclerImageView.TOP_LEFT)
                        scrollY < blankHeight -> recycler_ad.updateCenter(RecyclerImageView.BOTTOM_RIGHT)
                    }
                    if (blankHeight in oldScrollY..scrollY) {
                        recycler_ad.exchangeImage()
                    }
                    recycler_ad.updateRadius(scrollY - 500)
                }
            }

        }
    }
}
