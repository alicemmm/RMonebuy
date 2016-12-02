package mmm.asia.rmonebuy.ui.view.bottomtab;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mmm.asia.rmonebuy.R;

/**
 * Created by asia on 02/12/2016.
 */

public class BottomNavigationView extends RelativeLayout {
    private static final String TAG = BottomNavigationView.class.getSimpleName();

    private final int NAVIGATION_HEIGHT = (int) getResources().getDimension(R.dimen.bottom_navigation_height);

    private Context context;

    private ViewPager viewPager;

    private int navigationWidth;

    private int currentItemIndex = 0;
    private int oldItemIndex = 0;

    private List<BottomNavigationItem> bottomNavigationItems = new ArrayList<>();
    private List<View> viewList = new ArrayList<>();

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    public BottomNavigationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        currentItemIndex = 0;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        navigationWidth = BottomNavigationUtils.getActionbarSize(context);
        ViewGroup.LayoutParams params = getLayoutParams();

        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = NAVIGATION_HEIGHT;

        setLayoutParams(params);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (currentItemIndex < 0 || currentItemIndex > (bottomNavigationItems.size() - 1)) {
            currentItemIndex = 0;
        }

        if (bottomNavigationItems.size() == 0) {
            return;
        }

        viewList.clear();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (int i = 0; i < bottomNavigationItems.size(); i++) {
            final int index = i;

            final View view = inflater.inflate(R.layout.bottom_navigation_item, this, false);
            AppCompatImageView icon = (AppCompatImageView) view.findViewById(R.id.bottom_navigation_item_icon);
            TextView title = (TextView) view.findViewById(R.id.bottom_navigation_item_title);

            icon.setImageResource(bottomNavigationItems.get(i).getImageResource());
            title.setText(bottomNavigationItems.get(i).getTitle());
            title.setTextColor(bottomNavigationItems.get(i).getTitleColor());

            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBottomNavigationItemClick(index);
                }
            });

            viewList.add(view);
        }
    }

    private void onBottomNavigationItemClick(int index) {
        if (currentItemIndex == index) {
            return;
        }



        if (oldItemIndex != currentItemIndex) {
            oldItemIndex = currentItemIndex;
        }


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    public void addItemsWithViewPager(ViewPager viewPager, List<BottomNavigationItem> items) {
        this.viewPager = viewPager;
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            return;
        }

        if (adapter.getCount() != items.size()) {
            return;
        }

        addItems(items);
    }

    public void addItems(List<BottomNavigationItem> items) {
        if (items != null) {
            bottomNavigationItems.addAll(items);
        }
    }

    public void addItem(BottomNavigationItem item) {
        if (item != null) {
            bottomNavigationItems.add(item);
        }
    }


}
