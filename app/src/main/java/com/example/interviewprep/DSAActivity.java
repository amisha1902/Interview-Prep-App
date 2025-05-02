package com.example.interviewprep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DSAActivity extends AppCompatActivity {
    private String[] data = {"Graph", "Array", "Linked List", "Binary Tree", "Hashing", "Advanced Data Structures", "Strings"};
    private String[] topic = {"11 Chapters", "08 Chapters", "03 Chapters", "04 Chapters", "05 Chapters", "11 Chapters","08 Chapters"};
    private int[] icons = {
            R.drawable.arr,
            R.drawable.arr,
            R.drawable.arr,
            R.drawable.arr,
            R.drawable.arr,
            R.drawable.arr,
            R.drawable.arr
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsaactivity);
        ListView lvdata = findViewById(R.id.lvdatastructures);
        DataAdapter adapter = new DataAdapter();
        lvdata.setAdapter(adapter);
    }

    public class DataAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(DSAActivity.this)
                        .inflate(R.layout.code_category_item_layout, parent, false);
            }

            // Get the TextViews for language name and chapters
            ImageView imgLanguageIcon = convertView.findViewById(R.id.imgLanguageIcon);

            TextView tvLanguageName = convertView.findViewById(R.id.tvLanguageName);
            TextView tvLanguageChapters = convertView.findViewById(R.id.tvLanguageChapters);

            // Set the text for language name and chapters
            imgLanguageIcon.setImageResource(icons[position]);
            tvLanguageName.setText(data[position]);
            tvLanguageChapters.setText(topic[position]);

            return convertView;
        }
    }
}