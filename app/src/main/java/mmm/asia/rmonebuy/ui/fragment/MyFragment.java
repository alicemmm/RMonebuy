package mmm.asia.rmonebuy.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mmm.asia.rmonebuy.R;
import mmm.asia.rmonebuy.base.BaseFragment;

public class MyFragment extends BaseFragment {
    public static final String TAG = MyFragment.class.getSimpleName();

    private String argument;
    private Context context;

    public MyFragment() {
    }

    public static MyFragment getInstance(String argument) {
        MyFragment fragment = new MyFragment();

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
        View view = inflater.inflate(R.layout.fragment_d, container, false);

        return view;
    }

}
