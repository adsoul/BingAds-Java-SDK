package com.microsoft.bingads.v12.api.test.entities.criterions.adgroup.location.write;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.v12.api.test.entities.criterions.adgroup.location.BulkAdGroupLocationCriterionTest;
import com.microsoft.bingads.v12.bulk.entities.BulkAdGroupLocationCriterion;
import com.microsoft.bingads.v12.campaignmanagement.LocationCriterion;

@RunWith(Parameterized.class)
public class BulkAdGroupLocationCriterionWriteDisplayNameTypeTest extends BulkAdGroupLocationCriterionTest {

    @Parameterized.Parameter(value = 1)
    public String propertyValue;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                	{"Test", "Test"},
                    {"", ""},
                    {null, null}
                }
        );
    }

    @Test
    public void testWrite() {
        testWriteProperty(
                "Name",
                datum,
                propertyValue,
                new BiConsumer<BulkAdGroupLocationCriterion, String>() {
                    @Override
                    public void accept(BulkAdGroupLocationCriterion c, String v) {
                        ((LocationCriterion)c.getBiddableAdGroupCriterion().getCriterion()).setDisplayName(v);
                    }
                }
        );
    }
}
