package pl.fixit.stargardo.client;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class StargardoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
