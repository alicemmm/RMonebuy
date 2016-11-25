package mmm.asia.rmonebuy.ui.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import mmm.asia.rmonebuy.R;
import mmm.asia.rmonebuy.ui.view.bottomNavigation.BottomNavigationView;
import mmm.asia.rmonebuy.ui.view.bottomNavigation.OnBottomNavigationItemClickListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    int[] mainTabColors = {0xFF00796B, 0xFF5B4947, 0xFF607D8B, 0xFFF57C00, 0xFFF57C00};

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.main_bottom_navigation_view);

        initFragment();

        bottomTabInit();
    }

    private void initFragment() {

    }

    private void bottomTabInit() {
        int[] image = {R.drawable.ic_account_balance_black_24dp, R.drawable.ic_favorite_black_24dp,
                R.drawable.ic_redeem_black_24dp, R.drawable.ic_person_black_24dp};
        int[] color = {ContextCompat.getColor(this, R.color.firstColor), ContextCompat.getColor(this, R.color.secondColor),
                ContextCompat.getColor(this, R.color.thirdColor), ContextCompat.getColor(this, R.color.fourthColor)};

        if (bottomNavigationView != null) {
            bottomNavigationView.isWithText(true);
            bottomNavigationView.isColoredBackground(true);
            bottomNavigationView.setTextActiveSize(getResources().getDimension(R.dimen.text_active));
            bottomNavigationView.setTextInactiveSize(getResources().getDimension(R.dimen.text_inactive));
            bottomNavigationView.setItemActiveColorWithoutColoredBackground(ContextCompat.getColor(this, R.color.firstColor));

            bottomNavigationView.addTab("Record", color[0], image[0]);
            bottomNavigationView.addTab("Like", color[1], image[1]);
            bottomNavigationView.addTab("Books", color[2], image[2]);
            bottomNavigationView.addTab("GitHub", color[3], image[3]);

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
        }

    }


//    private void BottomTabInit() {
//        PagerBottomTabLayout pagerBottomTabLayout = new PagerBottomTabLayout(this);
//
//        //用TabItemBuilder构建一个导航按钮
//        TabItemBuilder tabItemBuilder = new TabItemBuilder(this).create()
//                .setDefaultIcon(android.R.drawable.ic_menu_send)
//                .setText("信息")
//                .setSelectedColor(mainTabColors[0])
//                .setTag("A")
//                .build();
//
//        //构建导航栏,得到Controller进行后续控制
//        Controller controller = pagerBottomTabLayout.builder()
//                .addTabItem(tabItemBuilder)
//                .addTabItem(android.R.drawable.ic_menu_compass, "位置", mainTabColors[1])
//                .addTabItem(android.R.drawable.ic_menu_search, "搜索", mainTabColors[2])
//                .addTabItem(android.R.drawable.ic_menu_help, "帮助", mainTabColors[3])
////                .setMode(TabLayoutMode.HIDE_TEXT)
//                .setMode(TabLayoutMode.CHANGE_BACKGROUND_COLOR)
////                .setMode(TabLayoutMode.HIDE_TEXT| TabLayoutMode.CHANGE_BACKGROUND_COLOR)
//                .build();
//
////        controller.setMessageNumber("A",2);
////        controller.setDisplayOval(0,true);
//
//        controller.addTabItemClickListener(new OnTabItemSelectListener() {
//            @Override
//            public void onSelected(int index, Object tag) {
//
//            }
//
//            @Override
//            public void onRepeatClick(int index, Object tag) {
//
//            }
//        });
//    }


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
