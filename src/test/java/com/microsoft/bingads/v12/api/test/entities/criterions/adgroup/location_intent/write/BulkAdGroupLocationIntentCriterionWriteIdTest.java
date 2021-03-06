package com.microsoft.bingads.v12.api.test.entities.criterions.adgroup.location_intent.write;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.v12.api.test.entities.criterions.adgroup.location_intent.BulkAdGroupLocationIntentCriterionTest;
import com.microsoft.bingads.v12.bulk.entities.BulkAdGroupLocationIntentCriterion;

@RunWith(Parameterized.class)
public class BulkAdGroupLocationIntentCriterionWriteIdTest extends BulkAdGroupLocationIntentCriterionTest {

    @Parameter(value = 1)
    public Long propertyValue;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"123", 123L},
                        {"9223372036854775807", 9223372036854775807L},
                        {null, null}
                }
        );
    }

    @Test
    public void testWrite() {
        testWriteProperty(
                "Id",
                datum,
                propertyValue,
                new BiConsumer<BulkAdGroupLocationIntentCriterion, Long>() {
                    @Override
                    public void accept(BulkAdGroupLocationIntentCriterion c, Long v) {
                        c.getBiddableAdGroupCriterion().setId(v);
                    }
                }
        );
    }
}
