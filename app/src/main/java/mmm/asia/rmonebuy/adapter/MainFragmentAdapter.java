package mmm.asia.rmonebuy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mmm.asia.rmonebuy.ui.fragment.AFragment;
import mmm.asia.rmonebuy.ui.fragment.BFragment;
import mmm.asia.rmonebuy.ui.fragment.CFragment;
import mmm.asia.rmonebuy.ui.fragment.DFragment;

/**
 * Created by asia on 24/11/2016.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {
    private static final String TAG = MainFragmentAdapter.class.getSimpleName();

    private static final int pageCount = 4;

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AFragment.getInstance(position + "");
            case 1:
                return BFragment.getInstance(position + "");
            case 2:
                return CFragment.getInstance(position + "");
            case 3:
                return DFragment.getInstance(position + "");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return pageCount;
    }
}
