package mmm.asia.rmonebuy.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by asia on 12/12/2016.
 */

public class BaseUser implements Parcelable {
    private int id;
    private String imei;
    private int versionCode;
    private String versionName;
    private String nets;// 网络接入商
    private String netType;//网络类型
    private int screenWidth;
    private int screenHeight;
    private String phoneType;
    private String androidVersion;
    private String other1;
    private String other2;

    protected BaseUser(Parcel in) {
        id = in.readInt();
        imei = in.readString();
        versionCode = in.readInt();
        versionName = in.readString();
        nets = in.readString();
        netType = in.readString();
        screenWidth = in.readInt();
        screenHeight = in.readInt();
        phoneType = in.readString();
        androidVersion = in.readString();
        other1 = in.readString();
        other2 = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(imei);
        dest.writeInt(versionCode);
        dest.writeString(versionName);
        dest.writeString(nets);
        dest.writeString(netType);
        dest.writeInt(screenWidth);
        dest.writeInt(screenHeight);
        dest.writeString(phoneType);
        dest.writeString(androidVersion);
        dest.writeString(other1);
        dest.writeString(other2);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BaseUser> CREATOR = new Creator<BaseUser>() {
        @Override
        public BaseUser createFromParcel(Parcel in) {
            return new BaseUser(in);
        }

        @Override
        public BaseUser[] newArray(int size) {
            return new BaseUser[size];
        }
    };
}
