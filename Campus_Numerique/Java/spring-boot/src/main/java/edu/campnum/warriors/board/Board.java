package edu.campnum.warriors.board;

import edu.campnum.warriors.contracts.Map;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "boards")
public class Board implements Map {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String name;

    @OneToMany
    private List<Cell> cells = new ArrayList<Cell>();

    private boolean built = false;

    protected Board() {}

    public Board(String name, ArrayList<Cell> cells, boolean built) {
        this.name = name;
        this.cells = cells;
        this.built = built;
    }

    public Board(String name) {
        this.name = name;
        this.built = false;
        this.cells = null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getNumberOfCase() {
        return this.cells.size();
    }

    public Long getId() {
        return id;
    }

    public Object findByCellNumber(int cellNumber) {
        for (Cell cell : cells) {
            if (cell.getCellNumber() == cellNumber) {
                return cell;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cells=" + cells +
                ", built=" + built +
                '}';
    }
}
