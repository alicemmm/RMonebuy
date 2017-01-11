package mmm.asia.rmonebuy.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.AsyncCustomEndpoints;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.CloudCodeListener;
import cn.bmob.v3.listener.SaveListener;
import mmm.asia.rmonebuy.R;
import mmm.asia.rmonebuy.base.BaseFragment;
import mmm.asia.rmonebuy.bean.TestProduct;

public class AFragment extends BaseFragment {
    public static final String TAG = AFragment.class.getSimpleName();

    private Context context;
    private String argument;

    private SwipeRefreshLayout swipeRefreshLayout;

    private boolean isRefresh = false;

    public AFragment() {
    }

    public static AFragment getInstance(String argument) {
        AFragment fragment = new AFragment();

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
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);

        initView();

        return view;
    }

    private void initView() {
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE,
                Color.GREEN,
                Color.YELLOW,
                Color.RED);
        swipeRefreshLayout.setDistanceToTriggerSync(300);
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!isRefresh) {
                    isRefresh = true;
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            swipeRefreshLayout.setRefreshing(false);
                            isRefresh = false;
                        }
                    }, 2000);
                }
            }
        });


//        testCloudMethod();

        testNoSql();
    }

    private void testNoSql(){
        TestProduct testProduct = new TestProduct();
        testProduct.setId(10001);
        testProduct.setPrice(5.5f);
        testProduct.setTitle("西瓜");
        testProduct.setType(1);
        List<BmobFile> urls = new ArrayList<>();
        urls.add(new BmobFile());
        urls.add(new BmobFile());
        urls.add(new BmobFile());
        urls.add(new BmobFile());
        testProduct.setPicFiles(urls);

        testProduct.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                Log.e("tag","s="+s.toString());
            }
        });
    }



    private void testCloudMethod() {
        //test对应你刚刚创建的云端逻辑名称
        String cloudCodeName = "getTest";
        JSONObject params = new JSONObject();
//name是上传到云端的参数名称，值是bmob，云端逻辑可以通过调用request.body.name获取这个值
        try {
            params.put("name", "bmob");
        } catch (JSONException e) {
            e.printStackTrace();
        }
//创建云端逻辑对象
        AsyncCustomEndpoints cloudCode = new AsyncCustomEndpoints();
//异步调用云端逻辑


        cloudCode.callEndpoint(cloudCodeName, params, new CloudCodeListener() {
            @Override
            public void done(Object o, BmobException e) {
                Log.e("bmob", "result = "+o.toString());
            }
        });
    }

    @Override
    public void onViewFirstAppear() {
        super.onViewFirstAppear();
    }

    @Override
    public void onViewAppear() {
        super.onViewAppear();
    }

    @Override
    public void onViewDisappear() {
        super.onViewDisappear();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
