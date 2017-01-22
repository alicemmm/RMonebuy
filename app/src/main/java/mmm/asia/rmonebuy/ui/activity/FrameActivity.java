package mmm.asia.rmonebuy.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import mmm.asia.rmonebuy.R;
import mmm.asia.rmonebuy.base.BaseActivity;

/**
 * Created by asia on 20/01/2017.
 */

public class FrameActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
