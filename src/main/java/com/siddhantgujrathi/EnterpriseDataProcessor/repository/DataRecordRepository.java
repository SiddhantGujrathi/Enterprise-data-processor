package com.siddhantgujrathi.EnterpriseDataProcessor.repository;

import com.siddhantgujrathi.EnterpriseDataProcessor.model.DataRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataRecordRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper to map DB rows to Java objects
    private RowMapper<DataRecord> rowMapper = (rs, rowNum) -> new DataRecord(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("type"),
            rs.getLong("timestamp")
    );

    // Save DataRecord to DB
    public int save(DataRecord record) {
        String sql = "INSERT INTO data_records (name, type, timestamp) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, record.getName(), record.getType(), record.getTimestamp());
    }

    // Fetch all records
    public List<DataRecord> findAll() {
        return jdbcTemplate.query("SELECT * FROM data_records", rowMapper);
    }

    // Fetch by ID
    public DataRecord findById(int id) {
        String sql = "SELECT * FROM data_records WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
