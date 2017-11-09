package com.xiaoqi.replugindemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.model.PluginInfo;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	/**
	 * 卸载外置插件
	 */
	private Button btnUninstallOuter;
	/**
	 * 安装外置插件
	 */
	private Button btnInstallOuter;
	/**
	 * 跳转到内置插件
	 */
	private Button btnIntoInner;
	/**
	 * 跳转到外置插件
	 */
	private Button btnIntoOuter;
	private PluginInfo info;

	private TextView mTvPluginList;
	private Button btnShow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		MyApplication.a = 2;
	}

	private void initView() {
		btnUninstallOuter =  findViewById(R.id.btn_uninstall_outer);
		btnUninstallOuter.setOnClickListener(this);
		btnInstallOuter =  findViewById(R.id.btn_install_outer);
		btnInstallOuter.setOnClickListener(this);
		btnIntoInner =  findViewById(R.id.btn_into_inner);
		btnIntoInner.setOnClickListener(this);
		btnIntoOuter =  findViewById(R.id.btn_into_outer);
		btnIntoOuter.setOnClickListener(this);
		mTvPluginList = findViewById(R.id.tv_plugin_list);
		btnShow = findViewById(R.id.btn_show_plugin);
		btnShow.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_uninstall_outer:
				RePlugin.uninstall("plugin");
				break;
			case R.id.btn_install_outer:
				File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "/plugin.apk");
				if (file.exists()) {
					Log.i("plugin", "file exists");
					info = RePlugin.install(Environment.getExternalStorageDirectory().getAbsolutePath() + "/plugin" +
							".apk");
				} else {
					Log.i("plugin", "file no exists");
				}

				break;
			case R.id.btn_into_inner:
//				Intent intentInner = new Intent();
//				intentInner.setComponent(new ComponentName("com.jumu.application", "com.jumu.activity.LoginActivity"));
//				RePlugin.startActivity(this, intent);
				// 方法2（快速创建Intent）
				if (!RePlugin.isPluginInstalled("plugin")) {
					Toast.makeText(this, "没有安装插件 plugin", Toast.LENGTH_SHORT).show();
				} else {
					Intent intent = RePlugin.createIntent("plugin",
							"com.xiaoqi.plugin.MainActivity");
					RePlugin.startActivity(this, intent);
				}


// 方法3（一行搞定）
//				RePlugin.startActivity(v.getContext(), new Intent(), "com.jumu.application",
//						"com.jumu.activity.LoginActivity");
				break;
			case R.id.btn_into_outer:
				if (info != null) {
					Intent intent = RePlugin.createIntent(info.getName(), "com.xiaoqi.plugin.MainActivity");
					startActivity(intent);
				} else if (!RePlugin.isPluginInstalled("plugin_outer")) {
					Toast.makeText(this, "没有安装插件 别名是：plugin_outer", Toast.LENGTH_SHORT).show();
				} else {
					RePlugin.startActivity(MainActivity.this, RePlugin.createIntent("plugin_outer",
							"com.xiaoqi.plugin.MainActivity"));
				}
//				Intent intentOuter = new Intent();
//				intentOuter.setComponent(new ComponentName("com.xiaoqi.plugin", "com.xiaoqi.plugin.MainActivity"));
//				startActivity(intentOuter);
				break;
			case R.id.btn_show_plugin:
				StringBuilder sb = new StringBuilder("");
				List<PluginInfo> list = RePlugin.getPluginInfoList();
				for(PluginInfo pluginInfo : list){
					sb.append(pluginInfo.getName()).append("\n");
				}
				mTvPluginList.setText(sb.toString());
				break;
		}
	}
}
