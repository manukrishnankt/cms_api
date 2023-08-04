package com.opensource.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opensource.cms.dto.MasterTableConfig;
import com.opensource.cms.service.MasterCollectionService;

@RestController
@RequestMapping(value = "/collectionGroup")
public class MasterTableController {

    @Autowired
    private MasterCollectionService masterCollectionService;

    @PostMapping("/create")
    public ResponseEntity<String> createNewCollection(@RequestBody MasterTableConfig masterTableConfig) {
        return ResponseEntity.ok(masterCollectionService.generateSQLQuery(masterTableConfig));
    }
}
