package com.opensource.cms.dto;

import java.util.List;

import lombok.Data;

@Data
public class MasterTableConfig {
    private String collectionGroupName;
    private List<MasterTableFieldConfig> collectionTableFields;
}
