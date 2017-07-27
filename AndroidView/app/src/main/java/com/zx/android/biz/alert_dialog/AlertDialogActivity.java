package com.zx.android.biz.alert_dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.zx.android.R;

/**
 * AlertDialog 创建对话框
 */
public class AlertDialogActivity extends AppCompatActivity {

    String[] strings = new String[]{
            "111111",
            "2222222",
            "33333333",
            "444444444"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public AlertDialog.Builder dialog() {
        return new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("标题")
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogActivity.this, "确认", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                })
                ;
    }

    /**
     * dialog
     * @param view
     */
    public void simpleDialog(View view) {
        dialog().setMessage("内容")
                .create()
                .show();
    }

    /**
     * list dialog
     * @param view
     */
    public void simpleListDialog(View view) {
        dialog()
                .setItems(strings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogActivity.this, strings[which], Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();
    }

    /**
     * 单选dialog
     * @param view
     */
    public void singleChoiceDialog(View view) {
        dialog()
                //默认选择0
                .setSingleChoiceItems(strings, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogActivity.this, strings[which], Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();
    }

    /**
     * 多选dialog
     * @param view
     */
    public void multiChoiceDialog(View view) {
        dialog()
                .setMultiChoiceItems(strings, new boolean[]{false, true, false, true}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(AlertDialogActivity.this, strings[which], Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();
    }

    public void customListDialog(View view) {
        dialog()
                .setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return strings.length;
                    }

                    @Override
                    public String getItem(int position) {
                        return strings[position];
                    }

                    @Override
                    public long getItemId(int position) {
                        return position;
                    }

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        TextView textView = new TextView(AlertDialogActivity.this);
                        textView.setText(getItem(position));
                        return textView;
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogActivity.this, strings[which], Toast.LENGTH_SHORT).show();
                    }
                })
        .create()
        .show();
    }
}
