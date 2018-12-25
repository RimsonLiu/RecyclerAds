package com.rimson.recyclerads.view

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ImageView

class RecyclerImageView(context: Context, attrs: AttributeSet?, defStyle: Int) :
    ImageView(context, attrs, defStyle) {
    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    private lateinit var mBitmap: Bitmap
    private var mStartX = 0f
    private var mStartY = 0f
    private var mRadius = 0
    private var clearPaint = Paint()

    companion object {
        const val TOP_LEFT = 0
        const val BOTTOM_RIGHT = 1
    }

    init {
        // 关闭硬件加速
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        clearPaint.isAntiAlias = true
        clearPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.XOR)
    }

    fun updateRadius(r: Int) {
        mRadius = r
        invalidate()
    }

    fun updateCenter(pos: Int) {
        Log.d("hehe", "updateCenter" + pos)
        mStartX = if (pos == 0) (measuredWidth * 0.25).toFloat()
        else (measuredWidth * 0.75).toFloat()
        mStartY = if (pos == 0) (measuredHeight * 0.25).toFloat()
        else (measuredHeight * 0.75).toFloat()
        mBitmap = (drawable as BitmapDrawable).bitmap
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawBitmap(mBitmap, 0f, 0f, null)
        canvas?.drawCircle(mStartX, mStartY, mRadius.toFloat(), clearPaint)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mBitmap = (drawable as BitmapDrawable).bitmap
    }

}