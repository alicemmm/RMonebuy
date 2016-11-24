package mmm.asia.rmonebuy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mmm.asia.rmonebuy.R;

public class AFragment extends Fragment {
    public static final String TAG = AFragment.class.getSimpleName();

    private boolean isViewFirstAppear = true;

    private String argument;

    private TextView textView;

    public AFragment() {
    }

    public static AFragment getInstance(String argument) {
        Bundle args = new Bundle();
        args.putString("argument", argument);

        AFragment fragment = new AFragment();
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
        View view = inflater.inflate(R.layout.fragment_a, container);
        textView = (TextView) view.findViewById(R.id.fragment_a_title_tv);
        textView.setText(argument);

        return view;
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

    public void onViewFirstAppear() {
    }

    public void onViewDisappear() {
    }


    public void onViewAppear() {
        if (isViewFirstAppear) {
            onViewFirstAppear();
            isViewFirstAppear = false;
        }
    }

}
