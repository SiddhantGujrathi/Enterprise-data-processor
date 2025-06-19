package com.siddhantgujrathi.EnterpriseDataProcessor.service;


import com.siddhantgujrathi.EnterpriseDataProcessor.model.DataRecord;
import com.siddhantgujrathi.EnterpriseDataProcessor.repository.DataRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class DataProcessorService {

    @Autowired
    private DataRecordRepository repository;

    private ExecutorService executor;

    @PostConstruct
    public void init() {
        // Fixed thread pool for concurrent processing
        executor = Executors.newFixedThreadPool(5); // can tune this
    }

    public void processAndSaveRecords(List<DataRecord> records) {
        for (DataRecord record : records) {
            executor.submit(() -> {
                try {
                    System.out.println("Processing: " + record.getName());
                    // Simulate processing delay
                    Thread.sleep(100);
                    repository.save(record);
                    System.out.println("Saved: " + record.getName());
                } catch (Exception e) {
                    System.err.println("Error saving record: " + record.getName());
                    e.printStackTrace();
                }
            });
        }
    }

    public List<DataRecord> getAllRecords() {
        return repository.findAll();
    }

    public DataRecord getRecordById(int id) {
        return repository.findById(id);
    }
}
