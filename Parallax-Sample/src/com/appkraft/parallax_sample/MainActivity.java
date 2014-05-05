package com.appkraft.parallax_sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.parallax_sample.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button scrollViewParallaxButton = (Button) findViewById(R.id.button_scrollview_parallax);
        Button listViewParallaxButton = (Button) findViewById(R.id.button_listview_parallax);

        scrollViewParallaxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ParallaxScrollViewActivity.class);
                startActivity(i);
            }
        });
        listViewParallaxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ParallaxListViewActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return false;
    }

}
