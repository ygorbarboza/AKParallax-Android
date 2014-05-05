package net.appkraft.parallax;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class ParallaxListView extends ListView implements OnScrollListener {

    public final static double NO_ZOOM = 1;
    private ArrayList<net.appkraft.parallax.OnOverScrollByListener> mOnOverScrollByList = new ArrayList<net.appkraft.parallax.OnOverScrollByListener>();
    private ArrayList<OnTouchEventListener> mOnTouchEventList = new ArrayList<OnTouchEventListener>();
    private ImageView mImageView;
    private int mDrawableMaxHeight = -1;
    private int mImageViewHeight = -1;
    private OnOverScrollByListener scrollByListener = new OnOverScrollByListener() {
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
    private OnTouchEventListener touchListener = new OnTouchEventListener() {
        @Override
        public void onTouchEvent(MotionEvent ev) {
            if (ev.getAction() == MotionEvent.ACTION_UP) {
                if (mImageViewHeight - 1 < mImageView.getHeight()) {
                    ResetAnimimation animation = new ResetAnimimation(
                            mImageView, mImageViewHeight);
                    animation.setDuration(300);
                    mImageView.startAnimation(animation);
                }
            }
        }
    };
    private net.appkraft.parallax.OnOverScrollByListener onScroll = new net.appkraft.parallax.OnOverScrollByListener() {

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
    private OnTouchEventListener onTouched = new OnTouchEventListener() {

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
    private double mZoomRatio = 1;

    public ParallaxListView(Context context, AttributeSet attrs,
                            int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    public ParallaxListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ParallaxListView(Context context) {
        super(context);
        init(context, null);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
    }

    public void setParallaxImageView(ImageView iv) {
        mImageView = iv;
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void init(Context context, AttributeSet attrs) {

        if (attrs != null) {

            TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                    R.styleable.ParallaxScrollView, 0, 0);

            mZoomRatio = a
                    .getFloat(R.styleable.ParallaxScrollView_zoomRatio, 1);

        }

        post(new Runnable() {

            @Override
            public void run() {

                setViewsBounds(mZoomRatio);

            }
        });

    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
                                   int scrollY, int scrollRangeX, int scrollRangeY,
                                   int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {

        boolean isCollapseAnimation = false;

        for (int i = 0; i < mOnOverScrollByList.size(); i++) {

            isCollapseAnimation = mOnOverScrollByList.get(i).overScrollBy(
                    deltaX, deltaY, scrollX, scrollY, scrollRangeX,
                    scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent)
                    || isCollapseAnimation;

        }

        return isCollapseAnimation ? true : super.overScrollBy(deltaX, deltaY,
                scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX,
                maxOverScrollY, isTouchEvent);

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        for (int i = 0; i < mOnTouchEventList.size(); i++) {

            mOnTouchEventList.get(i).onTouchEvent(ev);

        }

        return super.onTouchEvent(ev);

    }

    /**
     * Set the ImageView that will be used in the parallax changing his
     * {@link ImageView.ScaleType} to CENTER_CROP.
     *
     * @param view - An {@link ImageView} that will have the parallax effect.
     */

    public void setImageViewToParallax(ImageView imageView) {

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        mImageView = imageView;

        addOnScrolledListener(onScroll);
        addOnTouchListener(onTouched);

    }

    private void addOnScrolledListener(net.appkraft.parallax.OnOverScrollByListener onScrolled) {

        mOnOverScrollByList.add(onScrolled);

    }

    private void addOnTouchListener(OnTouchEventListener onTouched) {

        mOnTouchEventList.add(onTouched);

    }

    /**
     * Set the bounds of the views and set the zoom of the view.
     * <p/>
     * Necessary to get the size of the Views.
     * <p/>
     * Have to put in the {@link #onWindowFocusChanged(boolean)} of the
     * activity.
     *
     * @param zoomRatio Double - How many times is the max zoom of the image, minimum
     *                  1.
     */

    public void setViewsBounds(double zoomRatio) {

        if (mImageViewHeight == -1) {

            mImageViewHeight = mImageView.getHeight();

            double imageRatio = ((double) mImageView.getDrawable()
                    .getIntrinsicWidth()) / ((double) mImageView.getWidth());

            mDrawableMaxHeight = (int) ((mImageView.getDrawable()
                    .getIntrinsicHeight() / imageRatio) * (zoomRatio > 1 ? zoomRatio
                    : 1));

        }

    }

    private interface OnOverScrollByListener {
        public boolean overScrollBy(int deltaX, int deltaY, int scrollX,
                                    int scrollY, int scrollRangeX, int scrollRangeY,
                                    int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent);
    }

    private interface OnTouchEventListener {
        public void onTouchEvent(MotionEvent ev);
    }

    public class ResetAnimimation extends Animation {
        int targetHeight;
        int originalHeight;
        int extraHeight;
        View mView;

        protected ResetAnimimation(View view, int targetHeight) {
            this.mView = view;
            this.targetHeight = targetHeight;
            originalHeight = view.getHeight();
            extraHeight = this.targetHeight - originalHeight;
        }

        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {

            int newHeight;
            newHeight = (int) (targetHeight - extraHeight
                    * (1 - interpolatedTime));
            mView.getLayoutParams().height = newHeight;
            mView.requestLayout();
        }
    }

}
