package com.zx.db;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zx.db.dbHelp.DatabaseHelp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DictActivity extends AppCompatActivity {

    private DatabaseHelp databaseHelp;
    private SQLiteDatabase sqLiteDatabase;

    private EditText et_word, // 生词
            et_detail,  // 翻译
            et_search, // 查找内容
            et_delete, // 删除
            et_old_word,
            et_new_word;
    private Button btn_add, // 添加
            btn_search, // 查找
            btn_delete, // 删除
            btn_update; // 更新

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dict);

        databaseHelp = new DatabaseHelp(this, "MyDict.db3", null, 1);
        sqLiteDatabase = databaseHelp.getReadableDatabase();

        et_word = (EditText) findViewById(R.id.et_word);
        et_detail = (EditText) findViewById(R.id.et_detail);
        et_search = (EditText) findViewById(R.id.et_search);
        et_delete = (EditText) findViewById(R.id.et_delete);
        et_old_word = (EditText) findViewById(R.id.et_old_word);
        et_new_word = (EditText) findViewById(R.id.et_new_word);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_search = (Button) findViewById(R.id.btn_search);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_update = (Button) findViewById(R.id.btn_update);

        // 添加
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = et_word.getText().toString();
                String detail = et_detail.getText().toString();
                databaseHelp.insertData(sqLiteDatabase, word, detail);
                Toast.makeText(DictActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });

        // 查找
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = et_search.getText().toString();
                Cursor cursor = databaseHelp.query(sqLiteDatabase, key);

                ArrayList<Map<String, String>> list = cursorToList(cursor);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", list);
                Intent intent = new Intent(DictActivity.this, ResultActivity.class);
                intent.putExtra("Bundle", bundle);
                startActivity(intent);
            }
        });

        // 删除
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String delete = et_delete.getText().toString();
                if (TextUtils.isEmpty(delete)) {
                    Toast.makeText(DictActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                databaseHelp.delete(sqLiteDatabase, delete);
                Toast.makeText(DictActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newWord = et_new_word.getText().toString();
                String oldWord = et_old_word.getText().toString();

                if (TextUtils.isEmpty(newWord) || TextUtils.isEmpty(oldWord)) {
                    Toast.makeText(DictActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                databaseHelp.update(sqLiteDatabase, oldWord, newWord);
                Toast.makeText(DictActivity.this, "更新完成", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<Map<String, String>> cursorToList(Cursor cursor) {
        ArrayList<Map<String, String>> list = new ArrayList<>();

        // 遍历
        while (cursor.moveToNext()) {
            Map<String, String> map = new HashMap<>();
            map.put("word", cursor.getString(1));
            map.put("detail", cursor.getString(2));
            list.add(map);
        }
        return list;
    }

}
