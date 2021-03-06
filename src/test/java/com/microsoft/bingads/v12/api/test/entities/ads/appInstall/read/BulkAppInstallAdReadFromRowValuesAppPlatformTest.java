package com.microsoft.bingads.v12.api.test.entities.ads.appInstall.read;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.microsoft.bingads.internal.functionalinterfaces.Function;
import com.microsoft.bingads.v12.api.test.entities.ads.appInstall.BulkAppInstallAdTest;
import com.microsoft.bingads.v12.bulk.entities.BulkAppInstallAd;

public class BulkAppInstallAdReadFromRowValuesAppPlatformTest extends BulkAppInstallAdTest {

    @Parameter(value = 1)
    public String expectedResult;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"App platform string", "App platform string"},
                {null, null}
        });
    }

    @Test
    public void testRead() {
        this.testReadProperty("App Platform", this.datum, this.expectedResult, new Function<BulkAppInstallAd, String>() {
            @Override
            public String apply(BulkAppInstallAd c) {
                return c.getAppInstallAd().getAppPlatform();
            }
        });
    }
}
