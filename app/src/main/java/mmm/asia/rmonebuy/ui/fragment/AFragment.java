package mmm.asia.rmonebuy.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.List;

import mmm.asia.rmonebuy.R;
import mmm.asia.rmonebuy.base.BaseFragment;
import mmm.asia.rmonebuy.ui.activity.MainActivity;
import mmm.asia.rmonebuy.ui.view.StickyScrollView;
import mmm.asia.rmonebuy.ui.view.StickyViewPager;

public class AFragment extends BaseFragment {
    public static final String TAG = AFragment.class.getSimpleName();

    private Context context;
    private String argument;

    private SwipeRefreshLayout swipeRefreshLayout;

    private boolean isRefresh = false;

    private StickyScrollView stickyScrollView;

    private StickyViewPager bottomViewPager;
    private TabLayout bottomTabLayout;

    public AFragment() {
    }

    public static AFragment getInstance(String argument) {
        AFragment fragment = new AFragment();

        Bundle args = new Bundle();
        args.putString("argument", argument);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        Bundle bundle = getArguments();
        if (bundle != null) {
            argument = bundle.getString("argument", "");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        stickyScrollView = (StickyScrollView) view.findViewById(R.id.sticky_scroll_view);
        bottomViewPager = (StickyViewPager) view.findViewById(R.id.bottom_viewpager);
        bottomTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);

        initView();

        return view;
    }

    private void initView() {
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE,
                Color.GREEN,
                Color.YELLOW,
                Color.RED);
        swipeRefreshLayout.setDistanceToTriggerSync(300);
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!isRefresh) {
                    isRefresh = true;
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            swipeRefreshLayout.setRefreshing(false);
                            isRefresh = false;
                        }
                    }, 2000);
                }
            }
        });

        bottomViewPager.setAdapter(new SubPageAdapter(getChildFragmentManager()));
        bottomViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomTabLayout.setTabTextColors(
                ContextCompat.getColor(context, R.color.title_intense_color),
                ContextCompat.getColor(context, R.color.colorAccent)
        );
        bottomTabLayout.setupWithViewPager(bottomViewPager);
        bottomTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(bottomViewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                bottomViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onViewFirstAppear() {
        super.onViewFirstAppear();
    }

    @Override
    public void onViewAppear() {
        super.onViewAppear();
    }

    @Override
    public void onViewDisappear() {
        super.onViewDisappear();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stickyScrollView.notifyStickyAttributeChanged();
    }

    private static class SubPageAdapter extends FragmentPagerAdapter {

        public SubPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return BFragment.getInstance("item=" + position);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "标题" + position;
        }

    }
}
