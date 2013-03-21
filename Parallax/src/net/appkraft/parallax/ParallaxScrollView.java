package net.appkraft.parallax;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ScrollView;

public class ParallaxScrollView extends ScrollView {

	ArrayList<onOverScrollByListener> mOnOverScrollByList = new ArrayList<onOverScrollByListener>();
	ArrayList<onTouchEventListener> mOnTouchEventList = new ArrayList<onTouchEventListener>();
	ImageView mImageView;
	int mDrawableMaxHeight = -1;
	int mImageViewHeight = -1;
	public final static double NO_ZOOM = 1;

	public ParallaxScrollView(Context context) {
		super(context);
	}

	public ParallaxScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ParallaxScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
			int scrollY, int scrollRangeX, int scrollRangeY,
			int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
		
		boolean isCollapseAnimation = false;

		for (int i = 0; i < mOnOverScrollByList.size(); i++) {

			isCollapseAnimation = mOnOverScrollByList.get(i).overScrollBy(deltaX, deltaY, scrollX,
					scrollY, scrollRangeX, scrollRangeY, maxOverScrollX,
					maxOverScrollY, isTouchEvent) || isCollapseAnimation;

		}

		return isCollapseAnimation ? true : super.overScrollBy(deltaX, deltaY, scrollX, scrollY,
				scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY,
				isTouchEvent);

	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {

		for (int i = 0; i < mOnTouchEventList.size(); i++) {

			mOnTouchEventList.get(i).onTouchEvent(ev);

		}

		return super.onTouchEvent(ev);

	}

	/**
	 * Set the ImageView that will be used in the parallax.
	 * 
	 * @param iv
	 *            ImageView - ImageView to be used in parallax.
	 * 
	 */

	public void setImageViewToParallax(ImageView iv) {

		mImageView = iv;

		mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

		addOnScrolledListener(onScroll);
		addOnTouchListener(onTouched);

	}

	private interface onOverScrollByListener {

		public boolean overScrollBy(int deltaX, int deltaY, int scrollX,
				int scrollY, int scrollRangeX, int scrollRangeY,
				int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent);

	}

	private interface onTouchEventListener {

		public void onTouchEvent(MotionEvent ev);

	}

	private void addOnScrolledListener(onOverScrollByListener onScrolled) {

		mOnOverScrollByList.add(onScrolled);

	}

	private void addOnTouchListener(onTouchEventListener onTouched) {

		mOnTouchEventList.add(onTouched);

	}

	private onOverScrollByListener onScroll = new onOverScrollByListener() {

		@Override
		public boolean overScrollBy(int deltaX, int deltaY, int scrollX,
				int scrollY, int scrollRangeX, int scrollRangeY,
				int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {

			if (mImageView.getHeight() <= mDrawableMaxHeight && isTouchEvent) {

				if (deltaY < 0) {

					if (mImageView.getHeight() - deltaY / 2 >= mImageViewHeight) {

						mImageView.getLayoutParams().height = mImageView
								.getHeight() - deltaY / 2 < mDrawableMaxHeight ? mImageView
								.getHeight() - deltaY / 2
								: mDrawableMaxHeight;

						mImageView.requestLayout();

					}

				} else {

					if (mImageView.getHeight() > mImageViewHeight) {

						mImageView.getLayoutParams().height = mImageView
								.getHeight() - deltaY > mImageViewHeight ? mImageView
								.getHeight() - deltaY
								: mImageViewHeight;

						mImageView.requestLayout();

						return true;

					}

				}

			}

			return false;

		}
	};

	private onTouchEventListener onTouched = new onTouchEventListener() {

		@Override
		public void onTouchEvent(MotionEvent ev) {

			if (ev.getAction() == MotionEvent.ACTION_UP) {

				if (mImageViewHeight - 1 < mImageView.getHeight()) {
					BackAnimimation animation = new BackAnimimation(mImageView,
							mImageViewHeight, false);
					animation.setDuration(300);
					mImageView.startAnimation(animation);
				}

			}

		}
	};

	/**
	 * Set the bounds of the views and set the zoom of the view.
	 * <p>
	 * Necessary to get the size of the Views.
	 * <p>
	 * Have to put in the {@link #onWindowFocusChanged(boolean)} of the
	 * activity.
	 * 
	 * @param zoomRatio
	 *            Double - How many times is the max zoom of the image, minimum
	 *            1.
	 * 
	 */

	public void setViewsBounds(double zoomRatio) {

		if (mImageViewHeight == -1) {

			mImageViewHeight = mImageView.getHeight();

			double imageRatio = ((double) mImageView.getDrawable()
					.getIntrinsicWidth()) / ((double) mImageView.getWidth());

			mDrawableMaxHeight = (int) ((mImageView.getDrawable()
					.getIntrinsicHeight() / imageRatio) * (zoomRatio > 1 ? zoomRatio
					: 1));

			System.out.println(mDrawableMaxHeight);

		}

	}

}
