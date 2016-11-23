package mmm.asia.rmonebuy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.TabItemBuilder;
import me.majiajie.pagerbottomtabstrip.TabLayoutMode;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    int[] testColors = {0xFF00796B, 0xFF5B4947, 0xFF607D8B, 0xFFF57C00, 0xFFF57C00};

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomTabTest();

    }

    private void BottomTabTest() {
        PagerBottomTabLayout pagerBottomTabLayout = (PagerBottomTabLayout) findViewById(R.id.tab);

        //用TabItemBuilder构建一个导航按钮
        TabItemBuilder tabItemBuilder = new TabItemBuilder(this).create()
                .setDefaultIcon(android.R.drawable.ic_menu_send)
                .setText("信息")
                .setSelectedColor(testColors[0])
                .setTag("A")
                .build();

        //构建导航栏,得到Controller进行后续控制
        controller = pagerBottomTabLayout.builder()
                .addTabItem(tabItemBuilder)
                .addTabItem(android.R.drawable.ic_menu_compass, "位置", testColors[1])
                .addTabItem(android.R.drawable.ic_menu_search, "搜索", testColors[2])
                .addTabItem(android.R.drawable.ic_menu_help, "帮助", testColors[3])
//                .setMode(TabLayoutMode.HIDE_TEXT)
                .setMode(TabLayoutMode.CHANGE_BACKGROUND_COLOR)
//                .setMode(TabLayoutMode.HIDE_TEXT| TabLayoutMode.CHANGE_BACKGROUND_COLOR)
                .build();

//        controller.setMessageNumber("A",2);
//        controller.setDisplayOval(0,true);

        controller.addTabItemClickListener(new OnTabItemSelectListener() {
            @Override
            public void onSelected(int index, Object tag) {

            }

            @Override
            public void onRepeatClick(int index, Object tag) {

            }
        });
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
