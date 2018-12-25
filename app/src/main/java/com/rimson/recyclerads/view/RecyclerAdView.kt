package com.rimson.recyclerads.view

import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView

class RecyclerAdView(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) :
    FrameLayout(context, attrs, defStyleAttr, defStyleRes) {
    constructor(context: Context) : this(context, null, 0, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : this(context, attrs, defStyleAttr, 0)

    private var bottomImageView = ImageView(context)
    private var topImageView = RecyclerImageView(context)
    private var bottomBitmap: Bitmap? = null
    private var topBitmap: Bitmap? = null

    fun setImageBitmap(bottom: Bitmap, top: Bitmap) {
        bottomImageView.setImageBitmap(bottom)
        topImageView.setImageBitmap(top)
        this.addView(bottomImageView)
        this.addView(topImageView)
//        bottomBitmap = bottom
//        topBitmap = top
    }

    fun updateCenter(pos: Int) {
        topImageView.updateCenter(pos)
    }

    fun updateRadius(r: Int) {
        topImageView.updateRadius(r)
    }

    fun exchangeImage() {
        val topDrawable = topImageView.drawable
        val bottomDrawable = bottomImageView.drawable
        topImageView.setImageDrawable(bottomDrawable)
        bottomImageView.setImageDrawable(topDrawable)
    }

}