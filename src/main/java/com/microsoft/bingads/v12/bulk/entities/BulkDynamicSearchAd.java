package com.microsoft.bingads.v12.bulk.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.internal.functionalinterfaces.Function;
import com.microsoft.bingads.v12.bulk.BulkFileReader;
import com.microsoft.bingads.v12.bulk.BulkFileWriter;
import com.microsoft.bingads.v12.bulk.BulkOperation;
import com.microsoft.bingads.v12.bulk.BulkServiceManager;
import com.microsoft.bingads.v12.campaignmanagement.AdType;
import com.microsoft.bingads.v12.campaignmanagement.DynamicSearchAd;
import com.microsoft.bingads.v12.internal.bulk.BulkMapping;
import com.microsoft.bingads.v12.internal.bulk.MappingHelpers;
import com.microsoft.bingads.v12.internal.bulk.RowValues;
import com.microsoft.bingads.v12.internal.bulk.SimpleBulkMapping;
import com.microsoft.bingads.v12.internal.bulk.StringTable;

/**
 * Represents a dynamic search ad.
 *
 * This class exposes the {@link #setDynamicSearchtAd} and {@link #getDynamicSearchAd} methods
 * that can be used to read and write fields of the Dynamic Search Ad record in a bulk file.
 *
 * <p>
 *     For more information, see Dynamic Search Ad at
 *     <a href="https://go.microsoft.com/fwlink/?linkid=846127">https://go.microsoft.com/fwlink/?linkid=846127</a>
 * </p>
 *
 * @see BulkServiceManager
 * @see BulkOperation
 * @see BulkFileReader
 * @see BulkFileWriter
 */
public class BulkDynamicSearchAd extends BulkAd<DynamicSearchAd> {

    private static final List<BulkMapping<BulkDynamicSearchAd>> MAPPINGS;

    static {
        List<BulkMapping<BulkDynamicSearchAd>> m = new ArrayList<BulkMapping<BulkDynamicSearchAd>>();

        m.add(new SimpleBulkMapping<BulkDynamicSearchAd, String>(StringTable.Text,
                new Function<BulkDynamicSearchAd, String>() {
                    @Override
                    public String apply(BulkDynamicSearchAd c) {
                        return c.getAd().getText();
                    }
                },
                new BiConsumer<String, BulkDynamicSearchAd>() {
                    @Override
                    public void accept(String v, BulkDynamicSearchAd c) {
                        c.getAd().setText(v);
                    }
                }
        ));

        m.add(new SimpleBulkMapping<BulkDynamicSearchAd, String>(StringTable.Path1,
                new Function<BulkDynamicSearchAd, String>() {
                    @Override
                    public String apply(BulkDynamicSearchAd c) {
                        return c.getAd().getPath1();
                    }
                },
                new BiConsumer<String, BulkDynamicSearchAd>() {
                    @Override
                    public void accept(String v, BulkDynamicSearchAd c) {
                        c.getAd().setPath1(v);
                    }
                },
                true
        ));
        
        m.add(new SimpleBulkMapping<BulkDynamicSearchAd, String>(StringTable.Path2,
                new Function<BulkDynamicSearchAd, String>() {
                    @Override
                    public String apply(BulkDynamicSearchAd c) {
                        return c.getAd().getPath2();
                    }
                },
                new BiConsumer<String, BulkDynamicSearchAd>() {
                    @Override
                    public void accept(String v, BulkDynamicSearchAd c) {
                        c.getAd().setPath2(v);
                    }
                },
                true
        ));       

        m.add(new SimpleBulkMapping<BulkDynamicSearchAd, String>(StringTable.TextPart2,
                new Function<BulkDynamicSearchAd, String>() {
                    @Override
                    public String apply(BulkDynamicSearchAd c) {
                        return c.getAd().getTextPart2();
                    }
                },
                new BiConsumer<String, BulkDynamicSearchAd>() {
                    @Override
                    public void accept(String v, BulkDynamicSearchAd c) {
                        c.getAd().setTextPart2(v);
                    }
                },
                true
        ));
        MAPPINGS = Collections.unmodifiableList(m);
    }

    @Override
    public void processMappingsToRowValues(RowValues values, boolean excludeReadonlyData) {
        validatePropertyNotNull(getDynamicSearchAd(), "DynamicSearchAd");

        super.processMappingsToRowValues(values, excludeReadonlyData);

        MappingHelpers.<BulkDynamicSearchAd>convertToValues(this, values, MAPPINGS);
    }

    @Override
    public void processMappingsFromRowValues(RowValues values) {
        this.setAd(new DynamicSearchAd());
        
        this.getAd().setType(AdType.DYNAMIC_SEARCH);
        
        super.processMappingsFromRowValues(values);
        MappingHelpers.<BulkDynamicSearchAd>convertToEntity(values, MAPPINGS, this);
    }

    /**
     * Gets the dynamic search ad.
     */
    public DynamicSearchAd getDynamicSearchAd() {
        return this.ad;
    }

    /**
     * Sets the dynamic search ad.
     */
    public void setDynamicSearchAd(DynamicSearchAd ad) {
        this.setAd(ad);
    }
}
