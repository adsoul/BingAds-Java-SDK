package com.microsoft.bingads.v12.api.test.entities.ad_extension.action.write;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.v12.api.test.entities.ad_extension.action.BulkActionAdExtensionTest;
import com.microsoft.bingads.v12.bulk.entities.BulkActionAdExtension;

@RunWith(Parameterized.class)
public class BulkActionAdExtensionWriteToValuesActionTextTest extends BulkActionAdExtensionTest {

    @Parameter(value = 1)
    public String propertyValue;

    @Parameters
    public static Collection<Object[]> data() {
        // In this example, the parameter generator returns a List of
        // arrays.  Each array has two elements: { datum, expected }.
        // These data are hard-coded into the class, but they could be
        // generated or loaded in any way you like.
        return Arrays.asList(new Object[][]{
            {"Action Text", "Action Text"},
            {null, null},});
    }

    @Test
    public void testWrite() {
        this.<String>testWriteProperty("Action Text", this.datum, this.propertyValue, new BiConsumer<BulkActionAdExtension, String>() {
            @Override
            public void accept(BulkActionAdExtension c, String v) {
                c.setActionText(v);
            }
        });
    }
}
