package com.ultraon.aptdaggerespressotest;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by vitaliypopov on 26.12.14.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class MyUnitTest {

    @Test
    public void testForSuccess() {
        Assert.assertEquals("String", new String("Str" + "ing"));
    }

    @Test
    public void testForFail() {
        Assert.assertNotSame("String", new String("1Str" + "ing"));
    }
}
