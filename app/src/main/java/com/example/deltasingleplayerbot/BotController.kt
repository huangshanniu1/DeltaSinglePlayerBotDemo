package com.example.deltasingleplayerbot

import android.graphics.PointF
import android.os.Handler
import android.os.Looper

object BotController {
    private val handler = Handler(Looper.getMainLooper())
    private var running = false
    private var index = 0

    // 示例路线。坐标为屏幕比例，不绑定任何第三方游戏。
    private val route = listOf(
        PointF(.50f, .70f),
        PointF(.62f, .62f),
        PointF(.70f, .50f),
        PointF(.58f, .42f)
    )

    fun start() {
        if (running) return
        running = true
        index = 0
        step()
    }

    fun stop() {
        running = false
        handler.removeCallbacksAndMessages(null)
    }

    private fun step() {
        if (!running) return
        val p = route[index]
        BotAccessibilityService.instance?.swipeRelative(
            p.x, p.y, p.x, p.y, 120
        )
        index = (index + 1) % route.size
        handler.postDelayed({ step() }, 1200)
    }
}
