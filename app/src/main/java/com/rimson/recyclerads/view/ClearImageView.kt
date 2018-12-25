package com.rimson.recyclerads.view

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.rimson.recyclerads.R

class ClearImageView(context: Context, attrs: AttributeSet?, defStyle: Int) :
    ImageView(context, attrs, defStyle) {
    private var mBitmap: Bitmap? = null
    private var tempBitmap: Bitmap? = null
    private var mStartX = 0f
    private var mStartY = 0f

    private var mPaint = Paint()
    private var clearPaint = Paint()

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)

        mPaint.flags = Paint.ANTI_ALIAS_FLAG
        clearPaint.isAntiAlias = true
        clearPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.XOR)

//        clearPaint.color = Color.TRANSPARENT
//        mPaint.color = Color.RED
//        mPaint.strokeWidth = 3f
    }

    override fun onDraw(canvas: Canvas?) {
        Log.d("hehe", "onDraw")
        super.onDraw(canvas)
        val bitmap = (drawable as BitmapDrawable).bitmap
        bitmap.setHasAlpha(true)
        canvas?.drawBitmap(bitmap, 0f, 0f, mPaint)
//        val layer = canvas?.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null)
        mStartX = (measuredWidth * 0.75).toFloat()
        mStartY = (measuredHeight * 0.75).toFloat()
        canvas?.drawCircle(mStartX, mStartY, height.toFloat() / 10, clearPaint)

    }

}