package com.xiaoqi.replugindemo;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.RePluginApplication;
import com.qihoo360.replugin.RePluginConfig;

/**
 * Created by Administrator on 2017/11/8.
 */

public class MyApplication extends RePluginApplication {

	public static int a = 1;

	@Override
	protected RePluginConfig createConfig() {
		RePluginConfig c = new RePluginConfig();
		// 允许“插件使用宿主类”。默认为“关闭”
		c.setUseHostClassIfNotFound(true);
		// FIXME RePlugin默认会对安装的外置插件进行签名校验，这里先关掉，避免调试时出现签名错误
		c.setVerifySign(false);
		c.setPrintDetailLog(BuildConfig.DEBUG);
		c.setUseHostClassIfNotFound(true);
		// 针对“安装失败”等情况来做进一步的事件处理
//		c.setEventCallbacks(new HostEventCallbacks(this));
		c.setMoveFileWhenInstalling(true);
		// FIXME 若宿主为Release，则此处应加上您认为"合法"的插件的签名，例如，可以写上"宿主"自己的。
		// RePlugin.addCertSignature("AAAAAAAAA");

		return c;
	}

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
//		RePlugin.getConfig().setUseHostClassIfNotFound(true);
//		RePlugin.App.onCreate();
//
//		RePlugin.enableDebugger(this, BuildConfig.DEBUG);
////		RePlugin.getConfig().setUseHostClassIfNotFound(true);
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
}
