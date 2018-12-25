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

    private var mStartX = 0f
    private var mStartY = 0f
    private var mRadius = 0

    private var clearPaint = Paint()

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

    override fun onDraw(canvas: Canvas?) {
        Log.d("hehe", "onDraw")
        super.onDraw(canvas)
        val bitmap = (drawable as BitmapDrawable).bitmap
        mStartX = (measuredWidth * 0.75).toFloat()
        mStartY = (measuredHeight * 0.75).toFloat()
        canvas?.drawBitmap(bitmap, 0f, 0f, null)
        canvas?.drawCircle(mStartX, mStartY, mRadius.toFloat(), clearPaint)
    }


}