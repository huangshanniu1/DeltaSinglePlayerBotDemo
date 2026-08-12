package com.example.deltasingleplayerbot

import android.graphics.Bitmap
import android.graphics.Color

/**
 * 极简图像状态识别接口。
 *
 * 这里故意不绑定任何第三方游戏。
 * 对你自己的单机游戏，可把模板匹配 / OCR / OpenCV / ML Kit
 * 接到这个类中，然后返回自定义游戏状态。
 */
class ImageStateDetector {

    enum class State {
        UNKNOWN, MENU, IN_GAME, LOOT, EXTRACTION, DEAD, COMPLETE
    }

    fun detect(bitmap: Bitmap): State {
        // 示例：根据画面平均亮度做一个占位识别。
        // 实际项目中建议替换为：
        // 1. ROI 裁剪
        // 2. 模板匹配
        // 3. OCR
        // 4. 状态机融合
        var sum = 0L
        val stepX = maxOf(1, bitmap.width / 20)
        val stepY = maxOf(1, bitmap.height / 20)
        var n = 0
        var y = 0
        while (y < bitmap.height) {
            var x = 0
            while (x < bitmap.width) {
                sum += Color.red(bitmap.getPixel(x, y))
                n++
                x += stepX
            }
            y += stepY
        }
        val avg = if (n == 0) 0 else sum / n
        return if (avg < 35) State.MENU else State.UNKNOWN
    }
}
