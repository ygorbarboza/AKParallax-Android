package com.appkraft.parallax_sample;

import net.appkraft.parallax.ParallaxScrollView;

import com.example.parallax_sample.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView image;
	ParallaxScrollView parallax;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		parallax = (ParallaxScrollView) findViewById(R.id.scrollView1);
		image = (ImageView) findViewById(R.id.imageView1);

		parallax.setImageViewToParallax(image);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		return false;

	}

}
