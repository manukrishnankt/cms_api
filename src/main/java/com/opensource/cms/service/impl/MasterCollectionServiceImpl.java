package com.opensource.cms.service.impl;

import java.util.stream.Collectors;

import com.opensource.cms.dto.MasterTableConfig;
import com.opensource.cms.dto.MasterTableFieldConfig;
import com.opensource.cms.service.MasterCollectionService;
import com.opensource.cms.util.CMSUtils;

public class MasterCollectionServiceImpl implements MasterCollectionService {

    @Override
    public String createCollection(MasterTableConfig masterTableConfig) {
        return generateSQLQuery(masterTableConfig);
    }

    @Override
    public String generateSQLQuery(MasterTableConfig masterTableConfig) {
        String fieldLine = masterTableConfig.getCollectionTableFields().stream()
                .map(field -> {
                    return generateFieldStatement(field);
                }).collect(Collectors.joining(", "));
        return CMSUtils.CREATE_TABLE + fieldLine;
    }

    private String generateFieldStatement(MasterTableFieldConfig field) {
        String fieldStatement = "";

        return fieldStatement;
    }

}
