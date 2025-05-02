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

public class DILRActivity extends AppCompatActivity {
    private String[] dilr = {"Tables", "Line & Bar Graphs", "Pie Charts", "Quant-Based DI", "Cubes","Linear Arrangements","Circular Arrangements","Venn Diagrams","Binary Logics","Games $ Tournaments", "Network Flow Diagrams"};
    private String[] dilrchapters = {"04 Chapters", "05 Chapters", "03 Chapters", "03 Chapters", "","","","","","",""};
    private int[] dilricons ={
            R.drawable.arr,
            R.drawable.arr,
            R.drawable.arr,
            R.drawable.arr,
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
        setContentView(R.layout.activity_dilractivity);
        ListView lvdilr=findViewById(R.id.lvDILR);
        DILRAdapter adapter = new DILRAdapter();
        lvdilr.setAdapter(adapter);
    }
    public class DILRAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return dilr.length;
        }

        @Override
        public Object getItem(int position) {
            return dilr[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(DILRActivity.this)
                        .inflate(R.layout.code_category_item_layout, parent, false);
            }

            // Get the TextViews for language name and chapters
            ImageView imgLanguageIcon = convertView.findViewById(R.id.imgLanguageIcon);

            TextView tvLanguageName = convertView.findViewById(R.id.tvLanguageName);
            TextView tvLanguageChapters = convertView.findViewById(R.id.tvLanguageChapters);

            // Set the text for language name and chapters
            imgLanguageIcon.setImageResource(dilricons[position]);
            tvLanguageName.setText(dilr[position]);
            tvLanguageChapters.setText(dilrchapters[position]);

            return convertView;
        }

    }
}