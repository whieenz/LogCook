package com.whieenz.logcook;

import android.app.Application;

import com.whieenz.LogCook;

/**
 * Created by whieenz on 2017/11/25.
 *
 */

public class AppManager extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        String logPath = "";
        String logName = "";
        LogCook.getInstance()
                .setLogPath(logPath)
                .setLogName(logName)
                .isOpen(true)
                .isSave(true)
                .initialize();
    }
}
