package com.opensource.cms.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class MasterTableConfig {
    private String collectionGroupName;
    private List<MasterTableFieldConfig> collectionTableFields;
}
