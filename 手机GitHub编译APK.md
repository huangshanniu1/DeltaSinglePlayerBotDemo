# 手机 GitHub 一键编译 APK

## 1. 创建 GitHub 仓库

在手机浏览器打开 GitHub，创建一个新的空仓库，例如：

`DeltaSinglePlayerBotDemo`

建议选择 Private（私有）或 Public 均可。

## 2. 上传本工程

解压本 ZIP 后，把里面的全部文件和文件夹上传到仓库根目录。

必须看到这些内容：

- `app/`
- `.github/workflows/build-apk.yml`
- `build.gradle.kts`
- `settings.gradle.kts`
- `gradle.properties`

## 3. 运行云端构建

进入仓库：

`Actions` → `Build Android APK` → `Run workflow`

等待构建完成。

## 4. 下载 APK

打开刚完成的 workflow run。

进入页面下方的：

`Artifacts`

点击：

`DeltaSinglePlayerBotDemo-debug`

下载 ZIP。

解压后即可得到：

`app-debug.apk`

## 5. 如果 Actions 没有出现

先进入仓库的 Actions 页面，确认 workflow 已经被识别。

如果仓库是新建的，先提交一次文件，再刷新 Actions。

## 注意

GitHub Actions 是云端编译，不需要电脑。

这个工程仅用于你自己的单机测试游戏，不包含针对第三方联网游戏的外挂、注入、内存修改或反作弊规避。
