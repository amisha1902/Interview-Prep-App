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

public class HRActivity extends AppCompatActivity {
    private String[] hr = {"Traditional HR Interview Questions", "Behavioural HR Interview Questions", "Opinion Based HR Interview Questions"};
    private String[] hrtopics = {"10 Questions", "10 Questions", "10 Questions"};
    private int[] hricons ={
            R.drawable.arr,
            R.drawable.arr,
            R.drawable.arr
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hractivity);
        ListView lvhr = findViewById(R.id.lvHR);
        HRAdapter adapter = new HRAdapter();
        lvhr.setAdapter(adapter);
    }
    public class HRAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return hr.length;
        }

        @Override
        public Object getItem(int position) {
            return hr[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(HRActivity.this)
                        .inflate(R.layout.code_category_item_layout, parent, false);
            }

            // Get the TextViews for language name and chapters
            ImageView imgLanguageIcon = convertView.findViewById(R.id.imgLanguageIcon);

            TextView tvLanguageName = convertView.findViewById(R.id.tvLanguageName);
            TextView tvLanguageChapters = convertView.findViewById(R.id.tvLanguageChapters);

            // Set the text for language name and chapters
            imgLanguageIcon.setImageResource(hricons[position]);
            tvLanguageName.setText(hr[position]);
            tvLanguageChapters.setText(hrtopics[position]);

            return convertView;
        }

    }
}