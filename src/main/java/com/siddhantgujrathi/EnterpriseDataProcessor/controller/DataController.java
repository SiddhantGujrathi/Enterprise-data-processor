package com.siddhantgujrathi.EnterpriseDataProcessor.controller;


import com.siddhantgujrathi.EnterpriseDataProcessor.model.DataRecord;
import com.siddhantgujrathi.EnterpriseDataProcessor.service.DataProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataProcessorService service;

    // POST: Add list of data records
    @PostMapping("/bulk")
    public ResponseEntity<String> bulkInsert(@RequestBody List<DataRecord> records) {
        service.processAndSaveRecords(records);
        return ResponseEntity.ok("Processing started for " + records.size() + " records.");
    }

    // GET: Get all records
    @GetMapping
    public List<DataRecord> getAll() {
        return service.getAllRecords();
    }

    // GET: Get record by ID
    @GetMapping("/{id}")
    public ResponseEntity<DataRecord> getById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(service.getRecordById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
