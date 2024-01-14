package edu.campnum.warriors.board;

import edu.campnum.warriors.items.Item;

import javax.persistence.*;

@Entity
@Table(name = "cells")
public class Cell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Item item;

    private int cellNumber;

    @ManyToOne
    private Board board;

    protected Cell() {}

    public Cell(int cellNumber, Item item, Board board) {
        this.cellNumber = cellNumber;
        this.item = item;
        this.board = board;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "id=" + id +
                ", cellNumber=" + cellNumber +
                ", onCell='" + item + '\'' +
                '}';
    }
}
