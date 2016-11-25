package mmm.asia.rmonebuy;

import android.app.Application;
import android.content.Context;

import com.avos.avoscloud.AVOSCloud;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

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

        AVOSCloud.initialize(this, Config.cloudAppID, Config.cloudAppKey);
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
