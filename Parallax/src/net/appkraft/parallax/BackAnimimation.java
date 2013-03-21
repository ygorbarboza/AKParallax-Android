package net.appkraft.parallax;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

	public class BackAnimimation extends Animation {
	int targetHeight;
	int originalHeight;
	int extraHeight;
	View view;
	boolean down;

	protected BackAnimimation(View view, int targetHeight, boolean down) {
		this.view = view;
		this.targetHeight = targetHeight;
		this.down = down;
		originalHeight = view.getHeight();
		extraHeight = this.targetHeight - originalHeight;
	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {

		int newHeight;

		newHeight = (int) (targetHeight - extraHeight * (1 - interpolatedTime));

		view.getLayoutParams().height = newHeight;
		view.requestLayout();
	}

	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight) {
		super.initialize(width, height, parentWidth, parentHeight);

	}

}
