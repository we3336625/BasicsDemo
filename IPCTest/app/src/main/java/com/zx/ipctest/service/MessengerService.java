package com.zx.ipctest.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.zx.ipctest.constants.MyConstants;

/**
 * 【类功能说明】
 *
 * @author zhangxiang
 * @version v 2.0.0 2017/8/18 下午5:42 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class MessengerService extends Service {

    private static final String TAG = MessengerService.class.getSimpleName();

    private Messenger mMessenger = new Messenger(new MessengerHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

    private class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MyConstants.MSG_FROM_CLIENT:
                    Log.i(TAG, "收到client消息：  " + msg.getData().getString("msg"));

                    Messenger messenger = msg.replyTo;
                    Message replyMsg = Message.obtain(null,MyConstants.MSG_FROM_SERVICE);
                    Bundle bundle = new Bundle();
                    bundle.putString("reply", "this is service");
                    replyMsg.setData(bundle);
                    try {
                        messenger.send(replyMsg);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    super.handleMessage(msg);
                    break;
            }

        }
    }
}
