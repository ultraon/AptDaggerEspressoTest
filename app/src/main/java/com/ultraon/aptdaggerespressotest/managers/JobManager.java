package com.ultraon.aptdaggerespressotest.managers;

import android.util.Log;

/**
 * Created by vitaliypopov on 26.12.14.
 */
public class JobManager implements IJobManager {
    private static final String TAG = JobManager.class.getSimpleName();
    @Override
    public void doSomeJob() {
        Log.d(TAG, "Doing some job...");
    }

    @Override
    public String getSomeString() {
        return "Some string";
    }
}
