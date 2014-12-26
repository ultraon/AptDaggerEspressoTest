package com.ultraon.aptdaggerespressotest;

import android.app.Application;

import com.ultraon.aptdaggerespressotest.di.ApplicationModule;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by vitaliypopov on 26.12.14.
 */
public class App extends Application {
    private static App app;
    private ObjectGraph graph;

    public static App get() {
        return app;
    }

    public static void inject(Object object) {
        App.get().graph.inject(object);
    }

    public static <T> T produce(Class<T> clazz) {
        return App.get().graph.get(clazz);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initDI(); //i should comment this if i run unit tests because android-apt internal error
    }

    private void initDI() {
        graph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules() {
        return Arrays.<Object>asList(
                new ApplicationModule(this)
//                , new AnotherModule()
        );
    }

}
