package com.rimson.recyclerads

import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val top = BitmapFactory.decodeResource(resources, R.mipmap.top)
        val bottom = BitmapFactory.decodeResource(resources, R.mipmap.bottom)
        clear_image.setImageBitmap(top)

        rav.setImageBitmap(top, bottom)
        val topImageView = rav.topImageView
        val screenHeight = this.window.decorView.measuredHeight
        val base = blank_view_1.measuredHeight + rav.measuredHeight - screenHeight

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            scrollView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
                Log.d("hehe", scrollY.toString())
                if (scrollY > blank_view_1.measuredHeight && scrollY > oldScrollY) {
                    topImageView.visibility = View.INVISIBLE
                } else if (scrollY < oldScrollY) {
                    topImageView.visibility = View.VISIBLE
                }
            }
        }
    }
}
