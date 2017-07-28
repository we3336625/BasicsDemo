package com.zx.fragmenttest.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 【类功能说明】
 *
 * @author zhangxiang
 * @version v 1.4.8 2017/7/28 上午10:15 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class FragmentTest extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("test", "fragment---->onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i("test", "fragment---->onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("test", "fragment---->onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("test", "fragment---->onDetach");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("test", "fragment---->onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("test", "fragment---->onPause");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("test", "fragment---->onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("test", "fragment---->onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("test", "fragment---->onDestroy");
    }
}
