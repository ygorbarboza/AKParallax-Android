package com.appkraft.parallax_sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

import com.example.parallax_sample.R;

import net.appkraft.parallax.ParallaxScrollView;

public class ParallaxScrollViewActivity extends Activity {

	ImageView image;
	ParallaxScrollView parallax;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);

		parallax = (ParallaxScrollView) findViewById(R.id.scrollView1);
		image = (ImageView) findViewById(R.id.imageView1);

		parallax.setImageViewToParallax(image);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		return false;

	}

}
