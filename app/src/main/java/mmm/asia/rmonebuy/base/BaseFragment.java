package mmm.asia.rmonebuy.base;

import android.support.v4.app.Fragment;

/**
 * Created by asia on 25/11/2016.
 */

public abstract class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getSimpleName();

    private boolean isViewFirstAppear = true;

    public BaseFragment() {
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getView() != null) {
            if (isVisibleToUser)
                onViewAppear();
            else
                onViewDisappear();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (getUserVisibleHint())
            onViewAppear();
        else
            onViewDisappear();
    }

    @Override
    public void onPause() {
        super.onPause();

        onViewDisappear();
    }

    public void onViewAppear() {
        if (isViewFirstAppear) {
            onViewFirstAppear();
            isViewFirstAppear = false;
        }
    }

    public void onViewFirstAppear() {
    }

    public void onViewDisappear() {
    }
}
