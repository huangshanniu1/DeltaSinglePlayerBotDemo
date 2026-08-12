package com.example.deltasingleplayerbot

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var status: TextView
    private lateinit var log: TextView
    private val detector = ImageStateDetector()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        status = findViewById(R.id.status)
        log = findViewById(R.id.log)

        findViewById<TextView>(R.id.route).text = """
            1. 起点
            2. 资源区
            3. 撤离检查点
            4. 终点
        """.trimIndent()

        findViewById<MaterialButton>(R.id.accessibilityButton).setOnClickListener {
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        }

        findViewById<MaterialButton>(R.id.startButton).setOnClickListener {
            BotController.start()
            status.text = "状态：运行中"
            append("BotController.start()")
            append("等待图像状态……")
        }

        findViewById<MaterialButton>(R.id.stopButton).setOnClickListener {
            BotController.stop()
            status.text = "状态：已停止"
            append("BotController.stop()")
        }

        append("ImageStateDetector 已初始化")
        append("这是面向自有单机测试游戏的工程模板")
    }

    private fun append(s: String) {
        log.append("\n$s")
    }
}
