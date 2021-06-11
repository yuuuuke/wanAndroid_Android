package com.yuuuuke.wanandroid.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.ImageView
import com.yuuuuke.wanandroid.utils.dp2px

/**
 * description:圆头像
 *
 * @author zwp
 * @since 2021/6/8
 */
class CircleImageView : ImageView {

    private val mPaint = Paint()
    private val xfermode: PorterDuffXfermode
    private var srcBitmap: Bitmap? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        scaleType = ScaleType.CENTER_CROP
        xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        post {
            srcBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            mPaint.strokeWidth = dp2px(2F).toFloat()
            val canvas = Canvas(srcBitmap!!)
            canvas.drawCircle(
                width / 2F,
                height / 2F,
                (width - dp2px(10F).toFloat()) / 2,
                mPaint
            )
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let {
            if (srcBitmap == null) {
                return
            }
            val sc = canvas.saveLayer(
                0f,
                0f,
                width.toFloat(),
                height.toFloat(),
                null,
                Canvas.ALL_SAVE_FLAG
            )
            super.onDraw(canvas)
            mPaint.xfermode = xfermode
            canvas.drawBitmap(srcBitmap!!, 0f, 0f, mPaint)
            canvas.restoreToCount(sc)
            mPaint.xfermode = null
        }
    }
}