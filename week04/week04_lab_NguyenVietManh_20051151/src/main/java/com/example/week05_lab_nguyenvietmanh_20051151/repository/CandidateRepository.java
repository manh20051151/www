package com.example.week05_lab_nguyenvietmanh_20051151.repository;

import com.example.week05_lab_nguyenvietmanh_20051151.entity.Candidate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CandidateRepository {

    private final JdbcTemplate jdbcTemplate;

    public CandidateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private Candidate mapRowToCandidate(ResultSet rs, int rowNum) throws SQLException {
        Candidate candidate = new Candidate();
        candidate.setFirstName(rs.getString("first_name"));
        candidate.setMiddleName(rs.getString("middle_name"));
        candidate.setLastName(rs.getString("last_name"));
        candidate.setDob(rs.getDate("dob").toLocalDate());
        candidate.setEmail(rs.getString("email"));
        candidate.setAddress(rs.getString("address"));
        candidate.setPhone(rs.getString("phone"));
        return candidate;
    }

    // Create
    public int save(Candidate candidate) {
        String sql = "INSERT INTO candidate (first_name, middle_name, last_name, dob, email, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, candidate.getFirstName(), candidate.getMiddleName(), candidate.getLastName(), candidate.getDob(), candidate.getEmail(), candidate.getAddress(), candidate.getPhone());
    }

    // Read
    public Candidate findById(String id) {
        String sql = "SELECT * FROM candidate WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRowToCandidate, id);
    }

    public List<Candidate> findAll() {
        String sql = "SELECT * FROM candidate";
        return jdbcTemplate.query(sql, this::mapRowToCandidate);
    }

    // Update
    public int update(Candidate candidate) {
        String sql = "UPDATE candidate SET first_name = ?, middle_name = ?, last_name = ?, dob = ?, email = ?, address = ?, phone = ? WHERE id = ?";
        return jdbcTemplate.update(sql, candidate.getFirstName(), candidate.getMiddleName(), candidate.getLastName(), candidate.getDob(), candidate.getEmail(), candidate.getAddress(), candidate.getPhone(), candidate.getId());
    }

    // Delete
    public int deleteById(String id) {
        String sql = "DELETE FROM candidate WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
