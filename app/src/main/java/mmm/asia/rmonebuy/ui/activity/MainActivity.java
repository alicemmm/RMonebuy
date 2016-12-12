package mmm.asia.rmonebuy.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.avos.avoscloud.AVObject;

import mmm.asia.rmonebuy.R;
import mmm.asia.rmonebuy.ui.fragment.AFragment;
import mmm.asia.rmonebuy.ui.fragment.BFragment;
import mmm.asia.rmonebuy.ui.fragment.CFragment;
import mmm.asia.rmonebuy.ui.fragment.DFragment;
import mmm.asia.rmonebuy.ui.view.bottombar.BottomBar;
import mmm.asia.rmonebuy.ui.view.bottombar.BottomBarTab;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private BottomBar bottomBar;

    private FragmentManager fragmentManager;
    private Fragment[] mFragments;

    private AFragment fragmentA;
    private BFragment fragmentB;
    private CFragment fragmentC;
    private DFragment fragmentD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState != null) {
            fragmentA = (AFragment) fragmentManager.findFragmentByTag("tab0");
            fragmentB = (BFragment) fragmentManager.findFragmentByTag("tab1");
            fragmentC = (CFragment) fragmentManager.findFragmentByTag("tab2");
            fragmentD = (DFragment) fragmentManager.findFragmentByTag("tab3");
        }

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomBar = (BottomBar) findViewById(R.id.bottom_bar);

        initView();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    private void testCloud() {
        AVObject testObject = new AVObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
    }

    private void initView() {
        fragmentA = AFragment.getInstance("0");
        fragmentB = BFragment.getInstance("1");
        fragmentC = CFragment.getInstance("2");
        fragmentD = DFragment.getInstance("3");

        mFragments = new Fragment[]{fragmentA, fragmentB, fragmentC, fragmentD};

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fl_container, fragmentA, "tab0")
                .add(R.id.fl_container, fragmentB, "tab1")
                .add(R.id.fl_container, fragmentC, "tab2")
                .add(R.id.fl_container, fragmentD, "tab3")
                .hide(fragmentB)
                .hide(fragmentC)
                .hide(fragmentD)
                .show(fragmentA);

        transaction.commitAllowingStateLoss();

        bottomBar.addItem(new BottomBarTab(this, R.drawable.ic_home_black_24dp, getString(R.string.main_activity_tab_a)))
                .addItem(new BottomBarTab(this, R.drawable.ic_redeem_black_24dp, getString(R.string.main_activity_tab_b)))
                .addItem(new BottomBarTab(this, R.drawable.ic_favorite_black_24dp, getString(R.string.main_activity_tab_c)))
                .addItem(new BottomBarTab(this, R.drawable.ic_person_black_24dp, getString(R.string.main_activity_tab_d)));

        bottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.hide(mFragments[prePosition]);
                if (!mFragments[position].isAdded()) {
                    ft.add(R.id.fl_container, mFragments[position]);
                }

                ft.show(mFragments[position]);
                ft.commitAllowingStateLoss();


            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {
            }
        });

//        bottomBar.getItem(3).setUnreadCount(8);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
