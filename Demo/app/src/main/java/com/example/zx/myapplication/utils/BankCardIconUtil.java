package com.example.zx.myapplication.utils;

import android.text.TextUtils;
import android.widget.ImageView;

import com.example.zx.myapplication.R;


/**
 * Created by lison on 6/27/16.
 */
public class BankCardIconUtil {

    public static final String CHINA_BANK = "中国银行";
    public static final String NONG_YE_BANK = "农业银行";
    public static final String JIAN_SHE_BANK = "建设银行";
    public static final String ZHAO_SHANG_BANK = "招商银行";
    public static final String ZHE_SHANG_BANK = "浙商银行";
    public static final String GONG_SHANG_BANK = "工商银行";
    public static final String REN_MIN_BANK = "人民银行";

    /**
     * 设置银行图标
     *
     * @param bankName
     * @param iv       imageView
     */
    public static void setBankIcon(
            String bankName,
            ImageView iv
    ) {
        if (TextUtils.isEmpty(bankName)) {
            return;
        }
        switch (bankName) {
            case CHINA_BANK: {
                iv.setImageResource(R.drawable.pic_boc);
            }
            break;
            case NONG_YE_BANK: {
                iv.setImageResource(R.drawable.pic_abc);
            }
            break;
            case JIAN_SHE_BANK: {
                iv.setImageResource(R.drawable.pic_ccb);
            }
            break;
            case ZHAO_SHANG_BANK: {
                iv.setImageResource(R.drawable.pic_cmb);
            }
            break;
            case ZHE_SHANG_BANK: {
                iv.setImageResource(R.drawable.pic_czb);
            }
            break;
            case GONG_SHANG_BANK: {
                iv.setImageResource(R.drawable.pic_icbc);
            }
            break;
            case REN_MIN_BANK: {
                iv.setImageResource(R.drawable.pic_pbc);
            }
            break;
            default: {
                iv.setImageResource(R.drawable.bank_card);
            }
            break;
        }
    }
}
