package mmm.asia.rmonebuy.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by asia on 20/01/2017.
 */

public class SharedPreferenceUtil {

    private static final String SHARE_FILE_NAME = "base_one_share";

    private SharedPreferences preferences;

    public SharedPreferenceUtil(Context context) {
        preferences = context.getSharedPreferences(SHARE_FILE_NAME, Context.MODE_PRIVATE);
    }

    public SharedPreferenceUtil(Context context, String fileName) {
        preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    public void putString(String key, String value) {
        if (preferences == null) {
            return;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void putBoolean(String key, boolean value) {
        if (preferences == null) {
            return;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void putFloat(String key, float value) {
        if (preferences == null) {
            return;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public void putInt(String key, int value) {
        if (preferences == null) {
            return;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void putLong(String key, long value) {
        if (preferences == null) {
            return;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public void clear() {
        if (preferences == null) {
            return;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }

    public void remove(String key) {
        if (preferences == null) {
            return;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.apply();
    }

    public String getString(String key, String defValue) {
        if (preferences == null) {
            return null;
        }

        return preferences.getString(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        if (preferences == null) {
            return false;
        }

        return preferences.getBoolean(key, defValue);
    }

    public float getFloat(String key, float defValue) {
        if (preferences == null) {
            return -1.0f;
        }

        return preferences.getFloat(key, defValue);
    }

    public int getInt(String key, int defValue) {
        if (preferences == null) {
            return -1;
        }

        return preferences.getInt(key, defValue);
    }

    public long getLong(String key, long defValue) {
        if (preferences == null) {
            return -1;
        }
        return preferences.getLong(key, defValue);
    }

    public boolean contains(String key) {
        if (preferences == null) {
            return false;
        }

        return preferences.contains(key);
    }

}
