package mmm.asia.rmonebuy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mmm.asia.rmonebuy.R;
import mmm.asia.rmonebuy.base.BaseFragment;

public class CFragment extends BaseFragment {
    public static final String TAG = CFragment.class.getSimpleName();

    private String argument;

    private TextView textView;

    public CFragment() {
    }

    public static CFragment getInstance(String argument) {
        CFragment fragment = new CFragment();

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
        View view = inflater.inflate(R.layout.fragment_c, container, false);
        textView = (TextView) view.findViewById(R.id.fragment_c_title_tv);
        textView.setText(argument);

        return view;
    }

}
