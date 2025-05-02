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

public class QuantsActivity extends AppCompatActivity {
    private String[] quants = {"Numbers", "Arithematic", "Algebra", "Geometry", "PNC"};
    private String[] quantschapters = {"05 Chapters", "09 Chapters", "07 Chapters", "04 Chapters", "06 Chapters"};
    private int[] quantsicons ={
            R.drawable.arr,
            R.drawable.arr,
            R.drawable.arr,
            R.drawable.arr,
            R.drawable.arr
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quants);
        ListView lvquants=findViewById(R.id.lvQuants);
        Quants adapter = new Quants();
        lvquants.setAdapter(adapter);
    }
    public class Quants extends BaseAdapter{

        @Override
        public int getCount() {
            return quants.length;
        }

        @Override
        public Object getItem(int position) {
            return quants[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(QuantsActivity.this)
                        .inflate(R.layout.code_category_item_layout, parent, false);
            }

            // Get the TextViews for language name and chapters
            ImageView imgLanguageIcon = convertView.findViewById(R.id.imgLanguageIcon);

            TextView tvLanguageName = convertView.findViewById(R.id.tvLanguageName);
            TextView tvLanguageChapters = convertView.findViewById(R.id.tvLanguageChapters);

            // Set the text for language name and chapters
            imgLanguageIcon.setImageResource(quantsicons[position]);
            tvLanguageName.setText(quants[position]);
            tvLanguageChapters.setText(quantschapters[position]);

            return convertView;
        }

    }
}