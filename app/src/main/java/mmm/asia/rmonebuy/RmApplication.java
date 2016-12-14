package mmm.asia.rmonebuy;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import mmm.asia.rmonebuy.api.Config;

/**
 * Created by asia on 24/11/2016.
 */

public class RmApplication extends Application {

    private static Context context;
    private static Application application;

    private static RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        application = this;

        refWatcher = LeakCanary.install(this);

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        BmobConfig config =new BmobConfig.Builder(this)
        //设置appkey
        .setApplicationId(Config.bmobApplicationID)
        //请求超时时间（单位为秒）：默认15s
        .setConnectTimeout(30)
        //文件分片上传时每片的大小（单位字节），默认512*1024
        .setUploadBlockSize(1024*1024)
        //文件的过期时间(单位为秒)：默认1800s
        .setFileExpiration(2500)
        .build();
        Bmob.initialize(config);
    }

    public static Context getContext() {
        return context;
    }

    public static Application getApplication() {
        return application;
    }

    public static RefWatcher getRefWatcher() {
        return refWatcher;
    }
}
