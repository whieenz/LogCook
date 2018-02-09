#  [![](https://jitpack.io/v/whieenz/LogCook.svg)](https://jitpack.io/#whieenz/LogCook) LogCook
> 这是一款超超超超超级精简，实用的Android日志管理工具。

LogCook是一款非常简洁实用的Android日记管理工具。LogCook的中文翻译是日志厨师，你可以把它看作是一个日志美食家。


## 功能介绍
-  支持正常的日志输出
-  支持将日志输出并保存到指定路径的文件
-  支持日志开关可灵活控制是否输出日志
-  支持文件保存开关可灵活控制是否保存日志
-  支持自动将App异常崩溃报错信息保存到指定文件，方便跟踪处理

## 特点
作为一款日志管理工具它最大的特点就是**简单实用**，与Android原生的日志功能相比较它具有以及几个优势：
1. 支持把日志输出到指定文本文件
2. 支持捕获App异常奔溃闪退（Crash）并打印输出到指定文件
3. 支持日志开关可灵活控制是否输出日志
4. 支持文件保存开关可灵活控制是否保存日志
## 使用教程
### 一、添加依赖
**推荐Gradle引用：**

在外层build.gradle 文件中添加以下信息：
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```


在App文件夹下的build.gradle 文件中添加以下信息：
```
dependencies {
	 compile 'com.github.whieenz:LogCook:v1.0'
}
```
### 二、添加文件写入权限
在manifest.xml中添加user permission：
```
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"/>
```
### 三、初始化
新建一个继承自Application的类，如果项目中已经有的话就不用新建了。
重写onCreate()方法在onCreate()方法中初始化LogCook，代码如下：


```
 @Override
    public void onCreate() {
        super.onCreate();
        String logPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/com.whieenz.logCook/log";
        LogCook.getInstance() // 单例获取LogCook实例
                .setLogPath(logPath) //设置日志保存路径
                .setLogName("test.log") //设置日志文件名
                .isOpen(true)  //是否开启输出日志
                .isSave(true)  //是否保存日志
                .initialize(); //完成初始化Crash监听
    }
```
在manifest.xml中的application标签下添加android:name=".MyApplication"属性，代码如下：
```
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:name=".MyApplication"  
        android:theme="@style/AppTheme">
```

好了，到了这里LogCook的配置问题就全部完成，是不是觉得很简单？
### 四、开始使用
LogCook 的使用非常简单日志的格式完全兼容Android原生的日志打印方式。用例如下：
       
```
LogCook.v(TAG,"测试日志v");
LogCook.i(TAG,"测试日志i");
LogCook.d(TAG,"测试日志d");
LogCook.w(TAG,"测试日志w");
LogCook.e(TAG,"测试日志e");
LogCook.log("测试日志log");
```
### 五、注意事项

1. 日志的保存路径和文件名是在使用时自己设置的，请务必注意路径和文件名有效
2. Crash信息只有在App运行时发生Crash才会有捕获和保存，保存在初始化时指定的路径下
### 作者信息
##### whieenz  email：whieenz@163.com

**如果喜欢请给个 ☆   谢谢！**
