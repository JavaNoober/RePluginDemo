//package com.xiaoqi.replugindemo;
//
//import android.app.Application;
//import android.content.Context;
//import android.content.res.Configuration;
//
//import com.qihoo360.replugin.RePlugin;
//
///**
// * Created by Administrator on 2017/11/8.
// */
//
//public class MyApplication extends Application {
//
//	public static int a = 1;
//	@Override
//	protected void attachBaseContext(Context base) {
//		super.attachBaseContext(base);
//
//		RePlugin.App.attachBaseContext(this);
//	}
//
//	@Override
//	public void onCreate() {
//		super.onCreate();
//
//		RePlugin.App.onCreate();
//
//		RePlugin.enableDebugger(this, BuildConfig.DEBUG);
//		RePlugin.getConfig().setUseHostClassIfNotFound(true);
//	}
//
//	@Override
//	public void onLowMemory() {
//		super.onLowMemory();
//
//        /* Not need to be called if your application's minSdkVersion > = 14 */
//		RePlugin.App.onLowMemory();
//	}
//
//	@Override
//	public void onTrimMemory(int level) {
//		super.onTrimMemory(level);
//
//        /* Not need to be called if your application's minSdkVersion > = 14 */
//		RePlugin.App.onTrimMemory(level);
//	}
//
//	@Override
//	public void onConfigurationChanged(Configuration config) {
//		super.onConfigurationChanged(config);
//
//        /* Not need to be called if your application's minSdkVersion > = 14 */
//		RePlugin.App.onConfigurationChanged(config);
//	}
//}
