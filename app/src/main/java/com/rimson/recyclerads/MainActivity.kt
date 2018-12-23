package com.rimson.recyclerads

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.top)
//        Glide.with(this)
//            .load(bitmap)
//            .into(iv1)
        rav.setImageBitmap(bitmap, bitmap)

    }

}
