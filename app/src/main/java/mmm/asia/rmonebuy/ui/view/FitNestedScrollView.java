package mmm.asia.rmonebuy.ui.view;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

/**
 * Created by asia on 30/11/2016.
 */

public class FitNestedScrollView extends NestedScrollView {
    public FitNestedScrollView(Context context) {
        super(context);
    }

    public FitNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FitNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return super.dispatchNestedFling(velocityX, velocityY, true);
    }
}
