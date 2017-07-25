package com.zx.crazyandroid.biz.view.image_view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zx.crazyandroid.R;
import com.zx.crazyandroid.biz.BaseActivity;

/**
 * imageView 透明度 增加；减少；下一张， 局部放大
 */
public class ImageViewActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_plus,btn_minus,btn_next;
    private ImageView image1,image2;

    private int currentImg = 2;
    // 透明度
    private int alpha = 255;

    private int[] images = new int[] {
            R.drawable.bg1,
            R.drawable.bg2,
            R.drawable.bg3,
            R.drawable.bg4,
            R.drawable.bg5,
            R.drawable.bg6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_next = (Button) findViewById(R.id.btn_next);
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);

        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_next.setOnClickListener(this);

        image1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) image1.getDrawable();
                // 获取第一个图片显示框中的位图
                Bitmap bitmap = bitmapDrawable.getBitmap();
                // bitmap图片实际大小与第一个imageview的缩放比例
                double scaleY = 1.0 * bitmap.getHeight() / image1.getHeight();
                double scaleX = 1.0 * bitmap.getWidth() / image1.getWidth();
                // 获取需要显示的图片的开始点
                int x = (int) (event.getX() * scaleX);
                int y = (int) (event.getY() * scaleY);
                if (x + 120 > bitmap.getWidth())
                    x = bitmap.getWidth() - 120;
                if (y + 120 > bitmap.getHeight())
                    y = bitmap.getHeight() - 120;
                // 显示图片的指定区域
                image2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus:
                alpha += 20;
                break;
            case R.id.btn_minus:
                alpha -= 20;
                break;
            case R.id.btn_next:
                image1.setImageResource(images[++currentImg % images.length]);
                break;
        }
        if (alpha >= 255) {
            alpha = 255;
        } else if (alpha <= 0) {
            alpha = 0;
        }
        image1.setImageAlpha(alpha);
    }
}
