package mmm.asia.rmonebuy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mmm.asia.rmonebuy.R;
import mmm.asia.rmonebuy.base.BaseFragment;

public class DFragment extends BaseFragment {
    public static final String TAG = DFragment.class.getSimpleName();

    private String argument;

    public DFragment() {
    }

    public static DFragment getInstance(String argument) {
        DFragment fragment = new DFragment();

        Bundle args = new Bundle();
        args.putString("argument", argument);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            argument = bundle.getString("argument", "");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d, container, false);

        return view;
    }

}
