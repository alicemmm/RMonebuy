package mmm.asia.rmonebuy.ui.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import mmm.asia.rmonebuy.R;
import mmm.asia.rmonebuy.adapter.MainFragmentAdapter;
import mmm.asia.rmonebuy.ui.view.bottomNavigation.BottomNavigationView;
import mmm.asia.rmonebuy.ui.view.bottomNavigation.OnBottomNavigationItemClickListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.main_content_vp);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.main_bottom_navigation_view);

        initView();
    }

    private void initView() {
        int[] image = {R.drawable.ic_account_balance_black_24dp, R.drawable.ic_redeem_black_24dp,
                R.drawable.ic_favorite_black_24dp, R.drawable.ic_person_black_24dp};
        int[] color = {ContextCompat.getColor(this, R.color.firstColor), ContextCompat.getColor(this, R.color.secondColor),
                ContextCompat.getColor(this, R.color.thirdColor), ContextCompat.getColor(this, R.color.fourthColor)};

        int[] titles = {R.string.main_activity_tab_a, R.string.main_activity_tab_b,
                R.string.main_activity_tab_c, R.string.main_activity_tab_d};

        bottomNavigationView.isWithText(true);
        bottomNavigationView.isColoredBackground(true);
        bottomNavigationView.setTextActiveSize(getResources().getDimension(R.dimen.text_active));
        bottomNavigationView.setTextInactiveSize(getResources().getDimension(R.dimen.text_inactive));
        bottomNavigationView.setItemActiveColorWithoutColoredBackground(ContextCompat.getColor(this, R.color.firstColor));

        viewPager.setAdapter(new MainFragmentAdapter(getSupportFragmentManager()));
        bottomNavigationView.setUpWithViewPager(viewPager, titles, color, image);

        bottomNavigationView.setOnBottomNavigationItemClickListener(new OnBottomNavigationItemClickListener() {
            @Override
            public void onNavigationItemClick(int index) {
                switch (index) {
                    case 0:
                        Log.e(TAG, "Record");
                        break;
                    case 1:
                        Log.e(TAG, "Like");
                        break;
                    case 2:
                        Log.e(TAG, "Books");
                        break;
                    case 3:
                        Log.e(TAG, "GitHub");
                        break;
                }
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
