package com.upperlucky.customviewxfermode

import android.content.res.Resources
import android.util.TypedValue

/**
 * created by yunKun.wen on 2020/9/3
 * desc:
 */
val Float.px
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )