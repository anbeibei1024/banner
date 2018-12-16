package com.beibei.banner

import android.support.v4.view.ViewPager
import android.view.View

/**
 * author: beibei
 *
 * eventDesc: banner 切换动画效果
 */


 class ScaleTransformer : ViewPager.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        if (position < -1 || position > 1) {
            page.alpha = MIN_ALPHA
            page.scaleX = MIN_SCALE
            page.scaleY = MIN_SCALE
        } else if (position <= 1) { // [-1,1]
            val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
            if (position < 0) {
                val scaleX = 1 + 0.1f * position
                page.scaleX = scaleX
                page.scaleY = scaleX
            } else {
                val scaleX = 1 - 0.1f * position
                page.scaleX = scaleX
                page.scaleY = scaleX
            }
            page.alpha = MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA)
        }
    }

    companion object {
        private val MIN_SCALE = 0.9f
        //可以在这里更改动画的透明度
        private val MIN_ALPHA = 1f
    }
}