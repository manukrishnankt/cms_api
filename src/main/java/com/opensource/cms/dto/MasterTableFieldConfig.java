package com.opensource.cms.dto;

import lombok.Data;

@Data
public class MasterTableFieldConfig {
    private String fieldName;
    private String fieldDataType;
    private boolean fieldPrimaryKeyYN;
    private boolean fieldNotNullYN;
    private boolean fieldAutoIncrementYN;
    private String fieldLength;
    private boolean fieldDefaultYN;
    private String fieldDefaultValue;
}
