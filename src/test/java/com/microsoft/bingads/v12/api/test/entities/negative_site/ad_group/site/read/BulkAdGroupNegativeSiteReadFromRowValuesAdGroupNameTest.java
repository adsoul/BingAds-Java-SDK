package com.microsoft.bingads.v12.api.test.entities.negative_site.ad_group.site.read;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.microsoft.bingads.internal.functionalinterfaces.Function;
import com.microsoft.bingads.v12.api.test.entities.negative_site.ad_group.site.BulkAdGroupNegativeSiteTest;
import com.microsoft.bingads.v12.bulk.entities.BulkAdGroupNegativeSite;

public class BulkAdGroupNegativeSiteReadFromRowValuesAdGroupNameTest extends BulkAdGroupNegativeSiteTest {

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
        this.<String>testReadProperty("Ad Group", this.datum, this.expectedResult, new Function<BulkAdGroupNegativeSite, String>() {
            @Override
            public String apply(BulkAdGroupNegativeSite c) {
                return c.getAdGroupName();
            }
        });
    }
}
