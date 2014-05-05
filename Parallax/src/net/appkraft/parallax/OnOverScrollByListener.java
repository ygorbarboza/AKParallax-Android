package net.appkraft.parallax;

/**
 * Created by mobile on 5/5/14.
 */
public interface OnOverScrollByListener {
    boolean overScrollBy(int deltaX, int deltaY, int scrollX,
                         int scrollY, int scrollRangeX, int scrollRangeY,
                         int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent);
}
