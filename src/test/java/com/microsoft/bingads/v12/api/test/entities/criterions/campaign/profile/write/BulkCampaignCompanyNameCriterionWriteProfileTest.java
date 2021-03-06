package com.microsoft.bingads.v12.api.test.entities.criterions.campaign.profile.write;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.v12.api.test.entities.criterions.campaign.profile.BulkCampaignProfileCriterionTest;
import com.microsoft.bingads.v12.bulk.entities.BulkCampaignCompanyNameCriterion;
import com.microsoft.bingads.v12.campaignmanagement.ProfileCriterion;
import com.microsoft.bingads.v12.campaignmanagement.ProfileType;

@RunWith(Parameterized.class)
public class BulkCampaignCompanyNameCriterionWriteProfileTest extends BulkCampaignProfileCriterionTest<BulkCampaignCompanyNameCriterion> {

    @Before
    public void beforeClass() {
        this.setClass(BulkCampaignCompanyNameCriterion.class);
    }
    
    @Parameterized.Parameter(value = 1)
    public String propertyValue;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"Profile Name", "Profile Name"},
                        {"XXX YYY", "XXX YYY"},
                        {"", ""},
                        {null, null}
                }
        );
    }

    @Test
    public void testWrite() {
        testWriteProperty(
                "Profile",
                datum,
                propertyValue,
                new BiConsumer<BulkCampaignCompanyNameCriterion, String>() {
                    @Override
                    public void accept(BulkCampaignCompanyNameCriterion c, String v) {
                        Collection<ProfileType> types = ((ProfileCriterion) c.getBiddableCampaignCriterion().getCriterion()).getProfileType();
                        assertTrue("", types != null && types.size() == 1 && types.contains(ProfileType.COMPANY_NAME));
                        c.setProfileName(v);
                    }
                }
        );
    }
}
