package com.wordledemo.wordle.db;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class Database {
    private final JdbcTemplate jdbcTemplate;

    private static final String CREATE_TABLE_SQL = """
CREATE TABLE IF NOT EXISTS `activity` (
id IDENTITY PRIMARY KEY,
userId VARCHAR(255),
guess VARCHAR(255),
word VARCHAR(255),
time_stamp TIMESTAMP,
attempt INTEGER)
""";

    private static final String INSERT_SQL = "INSERT INTO `activity` (userId, guess, word, time_stamp, attempt) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM `activity` WHERE userId = ? ORDER BY attempt";
    private static final String COUNT_SQL = "SELECT COUNT(userId) FROM `activity` WHERE userId = ? AND word = ?";

    @PostConstruct
    public void createtable() {
        jdbcTemplate.execute(Database.CREATE_TABLE_SQL);
    }

    public void insert(DBEntry entry) {
        int attempt  = entry.attempt();
        if (entry.user() != null && attempt == 0) {
            attempt = jdbcTemplate.queryForObject(
                    Database.COUNT_SQL,
                    Integer.class,
                    entry.user(),
                    entry.word()
            );
        }

        jdbcTemplate.update(
                Database.INSERT_SQL,
                entry.user(), entry.guess(), entry.word(), Instant.now(), attempt
        );
    }

    public List<DBEntry> selectAll(String userId) {
        return jdbcTemplate.query(Database.SELECT_ALL_SQL, new ActivityRowMapper(), userId);
    }

    class ActivityRowMapper implements RowMapper<DBEntry> {
        @Override
        public DBEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new DBEntry(
                    rs.getString("userId"),
                    rs.getString("guess"),
                    rs.getString("word"),
                    rs.getInt("attempt")
            );
        }
    }
}
