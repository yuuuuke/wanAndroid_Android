package com.yuuuuke.wanandroid.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop
import com.yuuuuke.wanandroid.R
import com.yuuuuke.wanandroid.model.KnowledgeChildBean

class AutoWrapGroupLayout : ViewGroup {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setData(data: List<KnowledgeChildBean>) {
        removeAllViews()
        for (item in data) {
            val tv = TextView(context)
            tv.setPadding(20, 10, 20, 10)
            tv.text = item.name
            tv.gravity = Gravity.CENTER
            tv.background =
                ResourcesCompat.getDrawable(resources, R.drawable.bg_knowledge_item, null)
            tv.layoutParams = MarginLayoutParams(WRAP_CONTENT,WRAP_CONTENT).also {
                it.leftMargin = 15
                it.topMargin = 8
            }
            addView(tv)
        }
    }


    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    override fun generateLayoutParams(p: LayoutParams?): LayoutParams {
        return MarginLayoutParams(p)
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        return MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var measureHeight = 0
        if (childCount == 0) {
            // 没有子view
            super.onMeasure(
                widthMeasureSpec,
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.getMode(heightMeasureSpec))
            )
            return
        }
        val parentWidth = MeasureSpec.getSize(widthMeasureSpec)
        var thisLineWidth = 0
        for (index in 0 until childCount) {
            val view = getChildAt(index)
            measureChild(
                view,
                MeasureSpec.makeMeasureSpec(parentWidth, MeasureSpec.AT_MOST),
                heightMeasureSpec
            )
            thisLineWidth += view.measuredWidth + view.marginLeft + view.marginRight
            if (thisLineWidth > parentWidth) {
                // 应该换行了
                measureHeight += view.measuredHeight + view.marginTop + marginBottom
                thisLineWidth = view.measuredWidth + view.marginLeft + view.marginRight
            } else {
                if (index == childCount - 1) {
                    // 最后一个了
                    measureHeight += view.measuredHeight + view.marginTop + marginBottom
                }
            }
        }
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), measureHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var left = 0
        var top = 0
        var thisLineWidth = 0
        for (index in 0 until childCount) {
            val view = getChildAt(index)
            thisLineWidth += view.measuredWidth + view.marginLeft + marginRight
            if (thisLineWidth > (r - l)) {
                //换到下一行
                left = 0
                thisLineWidth = view.measuredWidth + view.marginLeft + marginRight
                top += view.marginTop + view.marginBottom + view.measuredHeight
            }
            val ct = top + view.marginTop
            val cl = left + view.marginLeft
            val cr = cl + view.measuredWidth + view.marginRight
            val cb = ct + view.measuredHeight + view.marginBottom
            view.layout(cl, ct, cr, cb)
            left += view.measuredWidth + view.marginLeft + marginRight
        }
    }

}