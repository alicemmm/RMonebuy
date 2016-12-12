package mmm.asia.rmonebuy.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by asia on 12/12/2016.
 */

public class CoreService extends Service {
    private static final String TAG = CoreService.class.getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
