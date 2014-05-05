package com.appkraft.parallax_sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.parallax_sample.R;

import net.appkraft.parallax.ParallaxListView;

public class ParallaxListViewActivity extends Activity {

    ImageView image;
    ParallaxListView parallax;
    String[] dummys = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        parallax = (ParallaxListView) findViewById(R.id.listView);

        parallax.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dummys));

        image = new ImageView(this);
        image.setImageResource(R.drawable.teste);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
        image.setLayoutParams(params);

        parallax.addHeaderView(image);
        parallax.setImageViewToParallax(image);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return false;

    }

}
