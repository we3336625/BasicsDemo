package com.zx.crazyandroid.biz.view.view_group.linear_layout.search_view;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.zx.crazyandroid.R;
import com.zx.crazyandroid.biz.BaseActivity;

/**
 * searchView  搜索
 */
public class SearchViewActivity extends BaseActivity {

    private SearchView searchView;
    private ListView listView;

    String[] strings = new String[]{
            "111111111",
            "222222222",
            "333333333"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setSubmitButtonEnabled(true);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText))
                    listView.clearTextFilter();
                else
                    listView.setFilterText(newText);
                return false;
            }
        });

        listView = (ListView) findViewById(R.id.listView);
        listView.setTextFilterEnabled(true);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings));
    }
}
