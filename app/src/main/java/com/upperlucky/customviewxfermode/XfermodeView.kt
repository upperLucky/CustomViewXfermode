package com.upperlucky.customviewxfermode

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * created by yunKun.wen on 2020/9/2
 * desc:
 */

val AVATOR_WIDTH = 200f.px
val BITMAP_PADDING = 50f.px
private val XFEROMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

class XfermodeView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rectF = RectF(
        BITMAP_PADDING,
        BITMAP_PADDING,
        BITMAP_PADDING + AVATOR_WIDTH,
        BITMAP_PADDING + AVATOR_WIDTH
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val count = canvas.saveLayer(rectF, null)
        // 画背景
        canvas.drawOval(rectF, paint)
        paint.xfermode = XFEROMODE
        canvas.drawBitmap(getAvator(AVATOR_WIDTH.toInt()), BITMAP_PADDING, BITMAP_PADDING, paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
    }

    fun getAvator(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.mipmap.icon, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.mipmap.icon, options)
    }
}