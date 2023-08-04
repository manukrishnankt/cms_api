package com.opensource.cms.service.impl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.opensource.cms.dto.MasterTableConfig;
import com.opensource.cms.dto.MasterTableFieldConfig;
import com.opensource.cms.service.MasterCollectionService;
import com.opensource.cms.util.CMSUtils;

@Service
public class MasterCollectionServiceImpl implements MasterCollectionService {

    @Override
    public String createCollection(MasterTableConfig masterTableConfig) {
        return this.generateSQLQuery(masterTableConfig);
    }

    @Override
    public String generateSQLQuery(MasterTableConfig masterTableConfig) {
        String fieldLine = masterTableConfig.getCollectionTableFields().stream()
                .map(this::generateFieldStatement).collect(Collectors.joining(", "));
        return CMSUtils.CMS_CREATE_TABLE + " " + masterTableConfig.getCollectionGroupName() + "( " + fieldLine + " );";
    }

    private String generateFieldStatement(MasterTableFieldConfig field) {
        return this.buildCommonFieldStatement(field);
    }

    private String buildCommonFieldStatement(MasterTableFieldConfig field) {
        String commonFieldConfig = field.getFieldName() + " " + field.getFieldDataType();
        if (isNumeric(field.getFieldLength())) {
            commonFieldConfig += "(" + field.getFieldLength() + ")";
        }
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

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
