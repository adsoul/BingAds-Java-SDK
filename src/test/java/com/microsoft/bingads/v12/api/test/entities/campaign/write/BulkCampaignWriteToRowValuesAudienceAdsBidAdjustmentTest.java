package com.microsoft.bingads.v12.api.test.entities.campaign.write;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.v12.api.test.entities.campaign.BulkCampaignTest;
import com.microsoft.bingads.v12.bulk.entities.BulkCampaign;

@RunWith(Parameterized.class)
public class BulkCampaignWriteToRowValuesAudienceAdsBidAdjustmentTest extends BulkCampaignTest {

    @Parameterized.Parameter(value = 1)
    public Integer propertyValue;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"1", 1},
                        {"2147483647", Integer.MAX_VALUE},
                        {"0", 0},
                        {"-1", -1},
                        {"-2147483648", Integer.MIN_VALUE},
                        {null, null}
                }
        );
    }

    @Test
    public void testWrite() {
        testWriteProperty(
                "Bid Adjustment",
                this.datum,
                this.propertyValue,
                new BiConsumer<BulkCampaign, Integer>() {
                    @Override
                    public void accept(BulkCampaign c, Integer v) {
                        c.getCampaign().setAudienceAdsBidAdjustment(v);
                    }
                }
        );
    }
}
