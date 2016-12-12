package mmm.asia.rmonebuy.ui.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by asia on 12/12/2016.
 */

public class StickyViewPager extends ViewPager {

    private int mMaxHeightSize = 0;

    public StickyViewPager(Context context) {
        this(context, null);
    }

    public StickyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        View maxHeightView = getChildAt(0);

        int size = getChildCount();
        for (int i = 0; i < size; i++) {
            View child = getChildAt(i);
            if (child != null && child.getVisibility() != GONE) {
                child.measure(widthMeasureSpec, heightMeasureSpec);
                if (child.getHeight() > maxHeightView.getHeight()) {
                    maxHeightView = child;
                }
            }
        }

        if (maxHeightView != null) {
            setMeasuredDimension(getMeasuredWidth(), measureHeight(heightMeasureSpec, maxHeightView));
        }
    }


    /**
     * Determines the height of this view
     *
     * @param measureSpec A measureSpec packed into an int
     * @param view        the base view with already measured height
     * @return The height of the view, honoring constraints from measureSpec
     */
    private int measureHeight(int measureSpec, View view) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            // set the height from the base view if available
            if (view != null) {
                result = view.getMeasuredHeight();
                if (result > mMaxHeightSize) {
                    mMaxHeightSize = result;
                } else {
                    result = mMaxHeightSize;
                }
            }
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
}
