package edu.campnum.warriors.db;

import com.google.gson.Gson;
import edu.campnum.warriors.board.Board;
import edu.campnum.warriors.board.Cell;
import edu.campnum.warriors.items.Item;
import edu.campnum.warriors.repositories.BoardRepository;
import edu.campnum.warriors.repositories.CellRepository;
import edu.campnum.warriors.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
@Component
public class JsonDb {
    private final String PATH = "/home/lauric/Bureau/Campus_Numerique/Java/spring-boot/src/main/resources/static/maps/";
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CellRepository cellRepository;

    @Autowired
    private ItemRepository itemRepository;

    public JsonDb() {
    }

    public void saveJsonToDb() {
        File dir = new File(PATH);
        File[] files = dir.listFiles();
        assert files != null;
        HashMap<String, String> transformedJson;

        for (File file : files) {
            transformedJson = this.transformJson(file.getName());
            this.saveMap(transformedJson);
        }
    }


    private void saveMap(HashMap<String, String> json) {
        Board board = new Board(json.get("MapName"));
        board = boardRepository.save(board);

        for (int i = 1; i <= 64; i++) {
            Item item = itemRepository.findByName(json.get(String.valueOf(i)));
            Cell cell = new Cell(i, item, board);
            cellRepository.save(cell);
        }
    }

    private HashMap<String, String> transformJson(String fileName) {
        String path = PATH + fileName;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        assert bufferedReader != null;
        return gson.fromJson(bufferedReader, HashMap.class);
    }



}
