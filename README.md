# DeltaSinglePlayerBotDemo

这是一个**面向你自己制作的单机测试游戏**的 Android 自动化工程模板。

## 已包含

- Kotlin + Android
- Android AccessibilityService
- `dispatchGesture()` 触摸/滑动接口
- 路线状态机入口
- 图像状态识别接口 `ImageStateDetector`
- 手机界面
- 开始 / 停止
- 路线点
- 日志

## 构建 APK

1. 用 Android Studio 打开此目录。
2. 等 Gradle 同步完成。
3. 选择 `Build -> Build APK(s)`。
4. APK 通常在：
   `app/build/outputs/apk/debug/app-debug.apk`

需要 JDK 17 和 Android SDK 35。

## 接入你自己的单机游戏

建议把自动化拆成：

`截图 -> ROI -> 图像识别 -> 状态机 -> 动作规划 -> Accessibility 手势`

例如：

`IN_GAME -> MOVE_TO_LOOT -> LOOT -> MOVE_TO_EXTRACTION -> EXTRACTION -> COMPLETE`

把自己的截图模板、UI 坐标和游戏状态接到 `ImageStateDetector.kt` 与 `BotController.kt` 即可。

## 关于屏幕截图

当前工程没有申请 MediaProjection，因此不会偷偷抓取其他应用画面。
如果你的单机游戏是自己开发的，最稳定的方案其实是让游戏本身暴露测试接口，
或者在开发版中提供状态/坐标调试接口，而不是依赖 OCR/纯图像识别。

## 限制

本工程不针对《三角洲行动》官方客户端，也不包含第三方游戏外挂、注入、
内存修改、反作弊规避或联网游戏自动化逻辑。


## 手机 GitHub 云端编译

本工程已加入 `.github/workflows/build-apk.yml`。将工程上传到 GitHub 后，在仓库的 Actions 页面运行 `Build Android APK`，完成后从 Artifacts 下载 `DeltaSinglePlayerBotDemo-debug`，解压即可得到 `app-debug.apk`。详细步骤见 `手机GitHub编译APK.md`。
