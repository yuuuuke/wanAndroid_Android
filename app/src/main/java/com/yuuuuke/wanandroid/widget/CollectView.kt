package com.yuuuuke.wanandroid.widget

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ImageView
import com.yuuuuke.wanandroid.R

/**
 * description:点赞的控件
 *
 * @author zwp
 * @since 2021/6/1
 */
class CollectView : ImageView {

    var isCollected = false
        set(value) {
            field = value
            imageTintList = if (value) {
                ColorStateList.valueOf(Color.parseColor("#e91e63"))
            } else {
                ColorStateList.valueOf(Color.parseColor("#f5f5f5"))
            }
        }

    var onClick: ((view: CollectView) -> Unit)? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        setImageDrawable(resources.getDrawable(R.drawable.icon_favorite))
        setOnClickListener {
            isCollected = !isCollected
            onClick?.invoke(this)
        }
    }
}