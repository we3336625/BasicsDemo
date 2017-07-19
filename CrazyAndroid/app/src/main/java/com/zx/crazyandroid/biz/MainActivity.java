package com.zx.crazyandroid.biz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zx.crazyandroid.R;

/**
 * 【类功能说明】
 * xml  与  java 代码 共同控制UI
 *
 * @author zhangxiang
 * @version v 1.0 2017/7/18 下午4:17 XLXZ Exp $
 * @email ex-zhangxiang@xianglin.cn
 */
public class MainActivity extends BaseActivity {

    int[] images = new int[]{
            R.drawable.chuxuka,
            R.drawable.jiechu,
            R.drawable.jieru,
            R.drawable.weixin,
            R.drawable.xianjin,
            R.drawable.xinyongka,
            R.drawable.zhifubao,
            R.drawable.zongjine
    };

    int currentImg = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        final ImageView imageView = new ImageView(this);
        imageView.setImageResource(images[0]);
        linearLayout.addView(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // %: 取余数   10%3 = 1
                imageView.setImageResource(images[++currentImg % images.length]);
                Log.i(TAG, "onClick: " + currentImg);
            }
        });
    }
}
