package com.microsoft.bingads.v12.api.test.entities.ad_extension.app.read;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.microsoft.bingads.internal.functionalinterfaces.Function;
import com.microsoft.bingads.v12.api.test.entities.ad_extension.app.BulkAppAdExtensionTest;
import com.microsoft.bingads.v12.bulk.entities.BulkAppAdExtension;

public class BulkAppAdExtensionReadFromRowValuesDestinationUrlTest extends BulkAppAdExtensionTest {

    @Parameter(value = 1)
    public String expectedResult;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Test text", "Test text"},
            {"", ""},
            {null, null}
        });
    }

    @Test
    public void testRead() {
        this.testReadProperty("Destination Url", this.datum, this.expectedResult, new Function<BulkAppAdExtension, String>() {
            @Override
            public String apply(BulkAppAdExtension c) {
                return c.getAppAdExtension().getDestinationUrl();
            }
        });
    }
}
