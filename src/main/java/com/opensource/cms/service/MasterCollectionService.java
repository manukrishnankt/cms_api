package com.opensource.cms.service;

import com.opensource.cms.dto.MasterTableConfig;

public interface MasterCollectionService {
    String createCollection(MasterTableConfig masterTableConfig);

    String generateSQLQuery(MasterTableConfig masterTableConfig);
}
