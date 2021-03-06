package com.microsoft.bingads.v12.campaignmanagement;

/**
 * Enum class for AdAdditionalField.
 */
public enum AdAdditionalField {

    TITLE_PART3("TitlePart3"),
    TEXT_PART2("TextPart2"),
    IMAGES("Images"),
    FINAL_URL_SUFFIX("FinalUrlSuffix"),
    TEXT_PART2_D_S_A("TextPart2DSA");
        
    private final String value;

    AdAdditionalField(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdAdditionalField fromValue(String v) {
        for (AdAdditionalField c : AdAdditionalField.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}