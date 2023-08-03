package com.opensource.cms.service.impl;

import java.util.stream.Collectors;

import com.opensource.cms.dto.MasterTableConfig;
import com.opensource.cms.dto.MasterTableFieldConfig;
import com.opensource.cms.service.MasterCollectionService;
import com.opensource.cms.util.CMSUtils;

public class MasterCollectionServiceImpl implements MasterCollectionService {

    @Override
    public String createCollection(MasterTableConfig masterTableConfig) {
        return this.generateSQLQuery(masterTableConfig);
    }

    @Override
    public String generateSQLQuery(MasterTableConfig masterTableConfig) {
        String fieldLine = masterTableConfig.getCollectionTableFields().stream()
                .map(field -> {
                    return this.generateFieldStatement(field);
                }).collect(Collectors.joining(", "));
        return CMSUtils.CMS_CREATE_TABLE + " " + fieldLine;
    }

    private String generateFieldStatement(MasterTableFieldConfig field) {
        return field.getFieldName() + this.buildCommonFieldStatement(field);
    }

    private String buildCommonFieldStatement(MasterTableFieldConfig field) {
        String commonFieldConfig = " ";
        if (field.isFieldAutoIncrementYN()) {
            commonFieldConfig += (" " + CMSUtils.CMS_PRIMARY_KEY);
        }
        if (field.isFieldNotNullYN()) {
            commonFieldConfig += (" " + CMSUtils.CMS_NOT_NULL);
        }
        if (field.isFieldPrimaryKeyYN()) {
            commonFieldConfig += (" " + CMSUtils.CMS_PRIMARY_KEY);
        }
        if (field.isFieldDefaultYN()) {
            commonFieldConfig += (" " + CMSUtils.CMS_DEFAULT);
            commonFieldConfig += (" " + field.getFieldDefaultValue());
        }
        return commonFieldConfig;
    }

}
