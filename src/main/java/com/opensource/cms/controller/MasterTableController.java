package com.opensource.cms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.opensource.cms.dto.MasterTableConfig;

@RestController(value = "/collection")
public class MasterTableController {

    @PostMapping("/create")
    public ResponseEntity<String> createNewCollection(@RequestBody MasterTableConfig masterTableConfig) {
        return ResponseEntity.ok("");
    }
}
