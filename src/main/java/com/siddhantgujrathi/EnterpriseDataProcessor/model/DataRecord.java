package com.siddhantgujrathi.EnterpriseDataProcessor.model;

public class DataRecord {
    private int id;
    private String name;
    private String type;
    private long timestamp;

    // Constructor
    public DataRecord(int id, String name, String type, long timestamp) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.timestamp = timestamp;
    }

    public DataRecord() {}

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}
