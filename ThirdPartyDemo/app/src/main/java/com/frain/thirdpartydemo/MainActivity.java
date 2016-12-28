package com.frain.thirdpartydemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.frain.thirdpartydemo.Activity.AgoraActivity;
import com.frain.thirdpartydemo.Activity.TencentLoginActivity;

public class MainActivity extends AppCompatActivity {
    Class[] activities = {TencentLoginActivity.class, AgoraActivity.class};
    String[] activitynames = {"腾讯第三方登录", "声网SDK接入"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);


        listView.setAdapter(new MyAdapter(this, activitynames));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (activities.length == activities.length) {
                    Intent intent = new Intent(MainActivity.this, activities[i]);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this
                            , "需要跳转的页面缺少", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private class MyAdapter extends BaseAdapter {
        String[] activitynames;
        Context context;

        MyAdapter(Context context, String[] activitynames) {
            this.activitynames = activitynames;
            this.context = context;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public Object getItem(int i) {
            return activitynames[i];
        }

        @Override
        public int getCount() {
            return activitynames.length;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder = null;
            if (view == null) {
                viewHolder = new ViewHolder();
                viewHolder.textView = new TextView(context);
                viewHolder.textView.setLayoutParams(new
                        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                view = viewHolder.textView;
                view.setTag(viewHolder);
            }
            viewHolder = (ViewHolder) view.getTag();
            viewHolder.textView.setText(activitynames[i]);
            return view;
        }

        class ViewHolder {
            TextView textView;
        }
    }
}
