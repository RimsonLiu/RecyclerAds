package com.rimson.recyclerads

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import com.bumptech.glide.Glide

class RecyclerAdView : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    private val mPaint = Paint()
    private val maskPaint = Paint()
    private val ovalPaint = Paint()
    private val clearPaint = Paint()

    private var topBitmap: Bitmap? = null
    private var bottomBitmap: Bitmap? = null
    private var tBitmap: Bitmap? = null
    private var bBitmap: Bitmap? = null
    public var topImageView = ImageView(context)
    public var bottomImageView = ImageView(context)

    private lateinit var bottomCanvas: Canvas
    private lateinit var maskCanvas: Canvas
    private var mRatio = -1f
    private var offset = 0.75f
    private var radius = 0

    init {
        // val typedArray = context.obtainStyledAttributes()
        maskPaint.color = Color.WHITE
        ovalPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        clearPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    public fun setImageBitmap(top: Bitmap, bottom: Bitmap) {
        Glide.with(this)
            .load(top)
            .into(topImageView)
        this.addView(topImageView, layoutParams)

    }

    public fun setRatio(ratio: Float) {
        if (ratio > 0.8f) {
            topBitmap = bBitmap
            bottomBitmap = tBitmap
            offset = 0.25f
        }
        if (ratio < 0f) {
            topBitmap = tBitmap
            bottomBitmap = bBitmap
            offset = 0.75f
        }
        mRatio = if (offset == 0.25f) 0.8f - ratio else ratio
        maskCanvas.drawPaint(clearPaint)
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }
}