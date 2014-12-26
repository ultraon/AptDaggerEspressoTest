package com.ultraon.aptdaggerespressotest.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.preference.PreferenceManager;
import android.view.inputmethod.InputMethodManager;

import com.ultraon.aptdaggerespressotest.App;
import com.ultraon.aptdaggerespressotest.BaseActivity;
import com.ultraon.aptdaggerespressotest.MainActivity;
import com.ultraon.aptdaggerespressotest.managers.IJobManager;
import com.ultraon.aptdaggerespressotest.managers.JobManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vitaliypopov on 16.12.14.
 */
@Module(library = true,
        complete = false,
        injects = {
                App.class,

                //Register Activities
                BaseActivity.class,
                MainActivity.class,

                //Register Managers
                JobManager.class,

                //Register external utilities
                SharedPreferences.class,
        })
public class ApplicationModule {
    private final App app;

    public ApplicationModule(App app) {
        this.app = app;
    }

    /**
     * Allow the app context to be injected but require that it be annotated with
     * to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton
    Context provideApplicationContext() {
        return app;
    }

    @Provides
    @Singleton
    public SharedPreferences provideDefaultSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    @Provides
    public InputMethodManager provideInputMethodManager() {
        return (InputMethodManager) app.getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Provides
    public WifiManager provideWifiManager() {
        return (WifiManager) app.getSystemService(Context.WIFI_SERVICE);
    }

    @Provides
    public IJobManager provideJobManager() {
        return new JobManager();
    }
}
