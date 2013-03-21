package net.appkraft.parallax;

import android.app.Activity;
import android.os.Bundle;
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

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {

		super.onWindowFocusChanged(hasFocus);

		parallax.setViewsBounds(parallax.NO_ZOOM);

	}

}
