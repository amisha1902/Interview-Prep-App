package com.example.interviewprep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class VerbalActivity extends AppCompatActivity {
    private String[] verbal = {"Para Summary", "Para Completition", "Odd one out", "Para Jumble"};
    private String[] verbalchapters = {"", " ", " ", ""};
    private int[] verbalicons ={
            R.drawable.arr,
            R.drawable.arr,
            R.drawable.arr,
            R.drawable.arr
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbal);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ListView lvverbal = findViewById(R.id.lvverbal);

        // Create and set a custom adapter for the ListView
        VerbalAdapter adapter = new VerbalAdapter();
        lvverbal.setAdapter(adapter);
    }
    public class VerbalAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return verbal.length;
        }

        @Override
        public Object getItem(int position) {
            return verbal[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Inflate the custom layout if it's not already inflated
            if (convertView == null) {
                convertView = LayoutInflater.from(VerbalActivity.this)
                        .inflate(R.layout.code_category_item_layout, parent, false);
            }

            // Get the TextViews for language name and chapters
            ImageView imgLanguageIcon = convertView.findViewById(R.id.imgLanguageIcon);

            TextView tvLanguageName = convertView.findViewById(R.id.tvLanguageName);
            TextView tvLanguageChapters = convertView.findViewById(R.id.tvLanguageChapters);

            // Set the text for language name and chapters
            imgLanguageIcon.setImageResource(verbalicons[position]);
            tvLanguageName.setText(verbal[position]);
            tvLanguageChapters.setText(verbalchapters[position]);

            return convertView;
        }

    }

}