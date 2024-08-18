package com.wordledemo.wordle;

import com.wordledemo.wordle.db.DBEntry;
import com.wordledemo.wordle.db.Database;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestDB {
    @Autowired
    private Database database;

    @Test
    public void testDatabase() {
        DBEntry entry = new DBEntry("user", "guess", "word", 3);
        database.insert(entry);
        List<DBEntry> entryList = database.selectAll("user");
        assertThat(entryList).size().isEqualTo(1);
        assertThat(entryList).element(0).isEqualTo(entry);
    }

    @Test
    public void testIncrement()
    {
        DBEntry entry = new DBEntry("OtherUser", "OtherGuess", "OtherWord", 0);
        database.insert(entry);

        DBEntry secondEntry = new DBEntry("OtherUser", "OtherGuess", "OtherWord", 0);
        database.insert(secondEntry);

        List<DBEntry> entryList = database.selectAll("OtherUser");

        assertThat(entryList).size().isEqualTo(2);
        assertThat(entryList).contains(
                entry,
                new DBEntry("OtherUser", "OtherGuess", "OtherWord", 1)
        );
    }
}
