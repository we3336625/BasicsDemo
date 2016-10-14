package com.example.zx.myapplication.biz.download;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.zx.myapplication.MyApplication;
import com.example.zx.myapplication.R;
import com.example.zx.myapplication.base.BaseActivity;
import com.example.zx.myapplication.utils.LogUtils;

import org.lzh.framework.updatepluginlib.UpdateBuilder;
import org.lzh.framework.updatepluginlib.callback.UpdateCheckCB;
import org.lzh.framework.updatepluginlib.callback.UpdateDownloadCB;
import org.lzh.framework.updatepluginlib.creator.ApkFileCreator;
import org.lzh.framework.updatepluginlib.model.Update;
import org.lzh.framework.updatepluginlib.model.UpdateChecker;
import org.lzh.framework.updatepluginlib.model.UpdateParser;
import org.lzh.framework.updatepluginlib.strategy.UpdateStrategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownLoadActivity extends BaseActivity {

	private Button mButtonSingle;

	private SeekBar mSeekBarDownload;

	private NotificationManager manager;
	private Notification notif;
	private int NOTIFCATION_ID = 10;
	private int downloadCount = 0;
	private String apkFile = "http://apk.hiapk.com/web/api.do?qt=8051&id=721";

	@Override
	protected int getLayoutId() {
		return R.layout.activity_down_load;
	}

	@Override
	protected void findViews() {
		super.findViews();
		mSeekBarDownload = (SeekBar) findViewById(R.id.seekBar_download);
		mButtonSingle = (Button) findViewById(R.id.button_download_single);
	}

	@Override
	protected void setupListeners() {
		super.setupListeners();
		mButtonSingle.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()){
			case R.id.button_download_single:
//
//				//点击通知栏后打开的activity
////				Intent intent = new Intent(TestAndroid4Activity.this,OtherActivity.class);
////
////				PendingIntent pIntent = PendingIntent.getActivity(TestAndroid4Activity.this, 0, intent, 0);
//				manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//				notif = new Notification();
//				notif.icon = R.drawable.icon;
//				notif.tickerText = "新通知";
//				//通知栏显示所用到的布局文件
//				notif.contentView = new RemoteViews(getPackageName(), R.layout.progress_notif);
////				notif.contentIntent = pIntent;
//				manager.notify(0, notif);
//				new SingleDownloadTask().execute();

				UpdateBuilder.create()
						.checkCB(new UpdateCheckCB() {

							// 更新检查错误的回调
							@Override
							public void onCheckError(int code, String errorMsg) {
								tip("更新失败：code:" + code + ",errorMsg:" + errorMsg);
							}

							// 用于取消更新时的回调
							@Override
							public void onUserCancel() {
								tip("用户取消更新");
							}

							// 用户点击忽略此版本更新时的回调
							@Override
							public void onCheckIgnore(Update update) {

							}

							// 有新版本APK更新的回调
							@Override
							public void hasUpdate(Update update) {

							}

							// 没有新版本的回调
							@Override
							public void noUpdate() {
								tip("无更新");
							}
						})
						.jsonParser(new UpdateParser() {
							@Override
							public Update parse(String response) {
								// 此处模拟一个Update对象，传入接口返回的原始数据进去保存。
								// 若用户需要自定义的时候。对于有额外参数。可从中获取并定制。
								Update update = new Update(response);
								// 此apk包的更新时间
								update.setUpdateTime(System.currentTimeMillis());
								// 此apk包的下载地址
								update.setUpdateUrl(apkFile);
								// 此apk包的版本号
								update.setVersionCode(2);
								// 此apk包的版本名称
								update.setVersionName("2.0");
								// 此apk包的更新内容
								update.setUpdateContent("测试更新");
								// 此apk包是否为强制更新
								update.setForced(false);
								// 是否显示忽略此次版本更新
								update.setIgnore(false);
								return update;
							}
						})
						// 此参数可不配置。配置在此作为全局的更新接口回调通知
						.checkCB(new UpdateCheckCB() {

							// 更新检查错误的回调
							@Override
							public void onCheckError(int code, String errorMsg) {
								Toast.makeText(DownLoadActivity.this, "更新失败：code:" + code + ",errorMsg:" + errorMsg, Toast.LENGTH_SHORT).show();
							}

							// 用于取消更新时的回调
							@Override
							public void onUserCancel() {
								Toast.makeText(DownLoadActivity.this, "用户取消更新", Toast.LENGTH_SHORT).show();
							}

							// 用户点击忽略此版本更新时的回调
							@Override
							public void onCheckIgnore(Update update) {

							}

							// 有新版本APK更新的回调
							@Override
							public void hasUpdate(Update update) {

							}

							// 没有新版本的回调
							@Override
							public void noUpdate() {
								Toast.makeText(DownLoadActivity.this, "无更新", Toast.LENGTH_SHORT).show();
							}
						})
						// 自定义更新策略，默认WIFI下自动下载更新
						.strategy(new UpdateStrategy() {
							@Override
							public boolean isShowUpdateDialog(Update update) {
								// 是否在检查到有新版本更新时展示Dialog。
								return false;
							}

							@Override
							public boolean isAutoInstall() {
								// 下载完成后，是否自动更新。若为false。则创建Dialog显示
								return false;
							}

							@Override
							public boolean isShowDownloadDialog() {
								// 在APK下载时。是否显示下载进度的Dialog
								return false;
							}
						})
						// 自定义更新策略，默认WIFI下自动下载更新
						.strategy(new UpdateStrategy() {
							@Override
							public boolean isShowUpdateDialog(Update update) {
								// 是否在检查到有新版本更新时展示Dialog。
								return true;
							}

							@Override
							public boolean isAutoInstall() {
								// 下载完成后，是否自动更新。若为false。则创建Dialog显示
								return false;
							}

							@Override
							public boolean isShowDownloadDialog() {
								// 在APK下载时。是否显示下载进度的Dialog
								return false;
							}
						})
						// 自定义版本检查
						.updateChecker(new UpdateChecker() {
							@Override
							public boolean check(Update update) {
								// 在此对应用版本进行比对检测。返回true说明该update版本需要被更新。false不需要更新
								return true;
							}
						})
						// 新版本APK下载时的回调
						.downloadCB(new UpdateDownloadCB() {
							// 下载开始
							@Override
							public void onUpdateStart() {

								downloadCount = 0;

								manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
								notif = new Notification();
								notif.icon = R.drawable.icon;
								notif.tickerText = "新通知";
								//通知栏显示所用到的布局文件
								notif.contentView = new RemoteViews(getPackageName(), R.layout.progress_notif);

								manager.notify(NOTIFCATION_ID, notif);

							}

							// 下载完成
							@Override
							public void onUpdateComplete(File file) {
								Message msg = new Message();
								msg.what = 1;
								handler.sendMessage(msg);
							}

							// 下载进度
							@Override
							public void onUpdateProgress(long current, long total) {
								LogUtils.i("current:" + current + "total:" + total);

								if (current == total){
									Message msg = new Message();
									msg.what = 0;
									msg.obj = 100;
									handler.sendMessage(msg);
								}

								int tmp = (int) (current * 100 / total);
								// 百分比增加 5 通知一次
								if (downloadCount == 0 || tmp - 5 > downloadCount) {
									downloadCount += 5;
									Message msg = new Message();
									msg.what = 0;
									msg.obj = tmp;
									handler.sendMessage(msg);
								}
							}

							// 下载apk错误
							@Override
							public void onUpdateError(int code, String errorMsg) {

							}
						})
						// 自定义下载文件缓存,默认参考
						.fileCreator(new ApkFileCreator() {
							@Override
							public File create(String versionName) {
								// versionName 为解析的Update实例中的update_url数据。在这里可自定义下载文件缓存路径及文件名。放置于File中
								File file = new File(Environment.getExternalStorageDirectory() + "/XiangLin/app/" + "XiangLin.apk");
								return file;
							}
						})
						.check(this);
				break;
			default:
				break;
		}
	}

	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch (msg.what) {
				case 0:
					mSeekBarDownload.setProgress((int) msg.obj);
					notif.contentView.setTextViewText(R.id.content_view_text1, msg.obj+"%");
					notif.contentView.setProgressBar(R.id.content_view_progress, 100, (int) msg.obj, false);
					manager.notify(NOTIFCATION_ID, notif);

					break;
				case 1:
					// 下载完成  notification 取消
//					NotificationManager manger = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
//					manger.cancel(NOTIFCATION_ID);
					downloadCount = 0;
					tip("下载完成");

					break;
				default:
					break;
			}
		}

	};

	//单线程下载，用的是AsyncTask线程
	class SingleDownloadTask extends AsyncTask<String,Integer,String> {
		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			mSeekBarDownload.setProgress((int) (values[0]*100.0/values[1]));
			Message msg = new Message();
			msg.what = 0;
			msg.obj = (int) (values[0]*100.0/values[1]);
			handler.sendMessage(msg);

//			notif.contentView.setTextViewText(R.id.content_view_text1, (int) (values[0]*100.0/values[1])+"%");
//			notif.contentView.setProgressBar(R.id.content_view_progress, 100, (int) (values[0]*100.0/values[1]), false);
//			manager.notify(0, notif);

			if ((values[0]*100.0/values[1]) == 100) {
//				tip("下载完成");
				msg.what = 1;
				handler.sendMessage(msg);
			}
		}

		@Override
		protected void onPostExecute(String s) {
			super.onPostExecute(s);
		}

		@Override
		protected String doInBackground(String... params) {
			try {
				URL url = new URL("http://hengdawb-app.oss-cn-hangzhou.aliyuncs.com/app-debug.apk");
				URLConnection connection = url.openConnection();
				int length = connection.getContentLength();
				InputStream is = connection.getInputStream();
				File file = new File(Environment.getExternalStorageDirectory(),"zx---.pdf");
				if(!file.exists()){
					file.createNewFile();
				}
				FileOutputStream fos = new FileOutputStream(file);
				byte[] array = new byte[1024];
				int index = is.read(array);
				int progress = 0;
				while(index!=-1){
					fos.write(array,0,index);
					progress+=index;
					publishProgress(progress,length);
					index = is.read(array);
				}
				fos.flush();
				fos.close();
				is.close();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

}
