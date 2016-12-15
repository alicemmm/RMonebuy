package mmm.asia.rmonebuy.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mmm.asia.rmonebuy.R;
import mmm.asia.rmonebuy.base.BaseFragment;

/**
 * Created by asia on 15/12/2016.
 */

public class AFItemFragment extends BaseFragment {
    public static final String TAG = AFragment.class.getSimpleName();

    private Context context;
    private String argument;

    private RecyclerView recyclerView;

    public AFItemFragment() {
    }

    public static AFItemFragment getInstance(String argument) {
        AFItemFragment fragment = new AFItemFragment();

        Bundle args = new Bundle();
        args.putString("argument", argument);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        Bundle bundle = getArguments();
        if (bundle != null) {
            argument = bundle.getString("argument", "");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_af_item, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_af_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        MyAdapter myAdapter = new MyAdapter(getData());
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutFrozen(true);
        return view;
    }

    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        for(int i = 0; i < 20; i++) {
            data.add(i + temp);
        }

        return data;
    }

    private static class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        private ArrayList<String> mData;

        public MyAdapter(ArrayList<String> data) {
            this.mData = data;
        }

        public void updateData(ArrayList<String> data) {
            this.mData = data;
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // 实例化展示的view
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_af_item_recycleview_item, parent, false);
            // 实例化viewholder
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // 绑定数据
            holder.mTv.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData == null ? 0 : mData.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {

            TextView mTv;

            public ViewHolder(View itemView) {
                super(itemView);
                mTv = (TextView) itemView.findViewById(R.id.item_tv);
            }
        }
    }
}
