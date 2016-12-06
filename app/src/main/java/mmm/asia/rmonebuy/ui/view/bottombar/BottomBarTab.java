package mmm.asia.rmonebuy.ui.view.bottombar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import mmm.asia.rmonebuy.R;

/**
 * Created by asia on 06/12/2016.
 */

public class BottomBarTab extends FrameLayout {
    private ImageView icon;
    private TextView tvTitle;
    private Context context;
    private int tabPosition = -1;

    private TextView tvUnreadCount;

    public BottomBarTab(Context context, @DrawableRes int icon, CharSequence title) {
        this(context, null, icon, title);
    }

    public BottomBarTab(Context context, AttributeSet attrs, int icon, CharSequence title) {
        this(context, attrs, 0, icon, title);
    }

    public BottomBarTab(Context context, AttributeSet attrs, int defStyleAttr, int icon, CharSequence title) {
        super(context, attrs, defStyleAttr);
        init(context, icon, title);
    }

    private void init(Context context, int icon, CharSequence title) {
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(new int[]{R.attr.selectableItemBackgroundBorderless});
        Drawable drawable = typedArray.getDrawable(0);
        setBackgroundDrawable(drawable);
        typedArray.recycle();

        LinearLayout lLContainer = new LinearLayout(context);
        lLContainer.setOrientation(LinearLayout.VERTICAL);
        lLContainer.setGravity(Gravity.CENTER);
        LayoutParams paramsContainer = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsContainer.gravity = Gravity.CENTER;
        lLContainer.setLayoutParams(paramsContainer);

        this.icon = new ImageView(context);
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 27, getResources().getDisplayMetrics());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
        this.icon.setImageResource(icon);
        this.icon.setLayoutParams(params);
        this.icon.setColorFilter(ContextCompat.getColor(context, R.color.tab_unselect));
        lLContainer.addView(this.icon);

        tvTitle = new TextView(context);
        tvTitle.setText(title);
        LinearLayout.LayoutParams paramsTv = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsTv.topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics());
        tvTitle.setTextSize(10);
        tvTitle.setTextColor(ContextCompat.getColor(context, R.color.tab_unselect));
        tvTitle.setLayoutParams(paramsTv);
        lLContainer.addView(tvTitle);

        addView(lLContainer);

        int min = dip2px(context, 20);
        int padding = dip2px(context, 5);
        tvUnreadCount = new TextView(context);
        tvUnreadCount.setTextSize(10);
        tvUnreadCount.setBackgroundResource(R.drawable.bg_msg_bubble);
        tvUnreadCount.setMinWidth(min);
        tvUnreadCount.setTextColor(Color.WHITE);
        tvUnreadCount.setPadding(padding, 0, padding, 0);
        tvUnreadCount.setGravity(Gravity.CENTER);
        FrameLayout.LayoutParams tvUnReadParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, min);
        tvUnReadParams.gravity = Gravity.CENTER;
        tvUnReadParams.leftMargin = dip2px(context, 17);
        tvUnReadParams.bottomMargin = dip2px(context, 14);
        tvUnreadCount.setLayoutParams(tvUnReadParams);
        tvUnreadCount.setVisibility(GONE);

        addView(tvUnreadCount);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            icon.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary));
            tvTitle.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
        } else {
            icon.setColorFilter(ContextCompat.getColor(context, R.color.tab_unselect));
            tvTitle.setTextColor(ContextCompat.getColor(context, R.color.tab_unselect));
        }
    }

    public void setTabPosition(int position) {
        tabPosition = position;
        if (position == 0) {
            setSelected(true);
        }
    }

    public int getTabPosition() {
        return tabPosition;
    }

    public void setUnreadCount(int num) {
        if (num <= 0) {
            tvUnreadCount.setText(String.valueOf(0));
            tvUnreadCount.setVisibility(GONE);
        } else {
            tvUnreadCount.setVisibility(VISIBLE);
            if (num > 99) {
                tvUnreadCount.setText("99+");
            } else {
                tvUnreadCount.setText(String.valueOf(num));
            }
        }
    }

    public int getUnreadCount() {
        int count = 0;
        if (TextUtils.isEmpty(tvUnreadCount.getText())) {
            return count;
        }
        if (tvUnreadCount.getText().toString().equals("99+")) {
            return 99;
        }
        try {
            count = Integer.valueOf(tvUnreadCount.getText().toString());
        } catch (Exception ignored) {
        }
        return count;
    }

    private int dip2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
}
