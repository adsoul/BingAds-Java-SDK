package com.microsoft.bingads.v12.bulk.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import com.microsoft.bingads.internal.UncheckedParseException;
import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.internal.functionalinterfaces.Function;
import com.microsoft.bingads.v12.bulk.BulkFileReader;
import com.microsoft.bingads.v12.bulk.BulkFileWriter;
import com.microsoft.bingads.v12.bulk.BulkOperation;
import com.microsoft.bingads.v12.bulk.BulkServiceManager;
import com.microsoft.bingads.v12.internal.bulk.BulkMapping;
import com.microsoft.bingads.v12.internal.bulk.MappingHelpers;
import com.microsoft.bingads.v12.internal.bulk.RowValues;
import com.microsoft.bingads.v12.internal.bulk.SimpleBulkMapping;
import com.microsoft.bingads.v12.internal.bulk.StringExtensions;
import com.microsoft.bingads.v12.internal.bulk.StringTable;
import com.microsoft.bingads.v12.internal.bulk.entities.SingleRecordBulkEntity;

/**
 * Represents an account that can be read or written in a bulk file.
 *
 * <p>
 * Properties of this class and of classes that it is derived from, correspond to fields of the Account record in a bulk file.
 * For more information, see Account at
 * <a href="https://go.microsoft.com/fwlink/?linkid=846127">https://go.microsoft.com/fwlink/?linkid=846127</a>.
 * </p>
 *
 * @see BulkServiceManager
 * @see BulkOperation
 * @see BulkFileReader
 * @see BulkFileWriter
 */
public class BulkAccount extends SingleRecordBulkEntity {

    private long id;

    private long customerId;

    private Calendar syncTime;
    
    private Boolean MSCLKIDAutoTaggingEnabled;

    private String trackingUrlTemplate;
    
    private String finalUrlSuffix;

    private static final List<BulkMapping<BulkAccount>> MAPPINGS;

    static {
        List<BulkMapping<BulkAccount>> m = new ArrayList<BulkMapping<BulkAccount>>();

        m.add(new SimpleBulkMapping<BulkAccount, Long>(StringTable.Id,
                new Function<BulkAccount, Long>() {
                    @Override
                    public Long apply(BulkAccount t) {
                        return t.getId();
                    }
                },
                new BiConsumer<String, BulkAccount>() {
                    @Override
                    public void accept(String v, BulkAccount c) {
                        c.setId(Long.parseLong(v));
                    }
                }
        ));

        m.add(new SimpleBulkMapping<BulkAccount, Long>(StringTable.ParentId,
                new Function<BulkAccount, Long>() {
                    @Override
                    public Long apply(BulkAccount t) {
                        return t.getCustomerId();
                    }
                },
                new BiConsumer<String, BulkAccount>() {
                    @Override
                    public void accept(String v, BulkAccount c) {
                        c.setCustomerId(StringExtensions.<Long>parseOptional(v, new Function<String, Long>() {
                            @Override
                            public Long apply(String value) {
                                return Long.parseLong(value);
                            }
                        }));
                    }
                }
        ));

        m.add(new SimpleBulkMapping<BulkAccount, String>(StringTable.SyncTime,
                new Function<BulkAccount, String>() {
                    @Override
                    public String apply(BulkAccount t) {
                        if (t.getSyncTime() == null) {
                            return null;
                        }

                        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                        format.setTimeZone(TimeZone.getTimeZone("UTC"));

                        return format.format(t.getSyncTime().getTime());
                    }
                },
                new BiConsumer<String, BulkAccount>() {
                    @Override
                    public void accept(String v, BulkAccount c) {
                        c.setSyncTime(StringExtensions.parseOptional(v, new Function<String, Calendar>() {
                            @Override
                            public Calendar apply(String t) {
                                Calendar c = new GregorianCalendar();
                                try {
                                    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                                    format.setTimeZone(TimeZone.getTimeZone("UTC"));

                                    c.setTime(format.parse(t));
                                } catch (ParseException ex) {
                                    throw new UncheckedParseException(ex);
                                }

                                return c;
                            }
                        }));
                    }
                }
        ));
        m.add(new SimpleBulkMapping<BulkAccount, Boolean>(StringTable.MSCLKIDAutoTaggingEnabled,
                new Function<BulkAccount, Boolean>() {
                    @Override
                    public Boolean apply(BulkAccount t) {
                        return t.getMSCLKIDAutoTaggingEnabled();
                    }
                },
                new BiConsumer<String, BulkAccount>() {
                    @Override
                    public void accept(String v, BulkAccount c) {
                        c.setMSCLKIDAutoTaggingEnabled(v == null ? null : Boolean.parseBoolean(v));
                    }
                }
        ));

        m.add(new SimpleBulkMapping<BulkAccount, String>(StringTable.TrackingTemplate,
                new Function<BulkAccount, String>() {
                    @Override
                    public String apply(BulkAccount t) {
                        return t.getTrackingUrlTemplate();
                    }
                },
                new BiConsumer<String, BulkAccount>() {
                    @Override
                    public void accept(String v, BulkAccount c) {
                        c.setTrackingUrlTemplate(StringExtensions.getValueOrEmptyString(v));
                    }
                }
        ));
        
        m.add(new SimpleBulkMapping<BulkAccount, String>(StringTable.FinalUrlSuffix,
                new Function<BulkAccount, String>() {
                    @Override
                    public String apply(BulkAccount c) {
                        return StringExtensions.toOptionalBulkString(c.getFinalUrlSuffix(), c.getId());
                    }
                },
                new BiConsumer<String, BulkAccount>() {
                    @Override
                    public void accept(String v, BulkAccount c) {
                        c.setFinalUrlSuffix(StringExtensions.getValueOrEmptyString(v));
                    }
                }
        ));
        
        MAPPINGS = Collections.unmodifiableList(m);
    }

    /**
     * Gets the identifier of the account.
     *
     * <p>
     *     Corresponds to the 'Id' field in the bulk file.
     * </p>
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the identifier of the account.
     *
     * <p>
     *     Corresponds to the 'Id' field in the bulk file.
     * </p>
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the identifier of the customer that contains the account.
     *
     * <p>
     *     Corresponds to the 'Parent Id' field in the bulk file.
     * </p>
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the identifier of the customer that contains the account.
     *
     * <p>
     *     Corresponds to the 'Parent Id' field in the bulk file.
     * </p>
     */
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the date and time that you last synced your account using the bulk service.
     *
     * <p>
     *     You should keep track of this value in UTC time.
     *     Corresponds to the 'Sync Time' field in the bulk file.
     * </p>
     */
    public Calendar getSyncTime() {
        return syncTime;
    }

    /**
     * Sets the date and time that you last synced your account using the bulk service.
     *
     * <p>
     *     You should keep track of this value in UTC time.
     *     Corresponds to the 'Sync Time' field in the bulk file.
     * </p>
     */
    public void setSyncTime(Calendar syncTime) {
        this.syncTime = syncTime;
    }
    

    public Boolean getMSCLKIDAutoTaggingEnabled() {
        return MSCLKIDAutoTaggingEnabled;
    }
    

    public void setMSCLKIDAutoTaggingEnabled(Boolean msclkAutoTagEnabled) {
        this.MSCLKIDAutoTaggingEnabled = msclkAutoTagEnabled;
    }

    public String getTrackingUrlTemplate() {
        return trackingUrlTemplate;
    }

    public void setTrackingUrlTemplate(String trackingTemplate) {
        this.trackingUrlTemplate = trackingTemplate;
    }

    public String getFinalUrlSuffix() {
        return finalUrlSuffix;
    }

    public void setFinalUrlSuffix(String finalUrlSuffix) {
        this.finalUrlSuffix = finalUrlSuffix;
    }

    @Override
    public void processMappingsFromRowValues(RowValues values) {
        MappingHelpers.<BulkAccount>convertToEntity(values, MAPPINGS, this);
    }

    @Override
    public void processMappingsToRowValues(RowValues values, boolean excludeReadonlyData) {
        MappingHelpers.convertToValues(this, values, MAPPINGS);
    }
}
