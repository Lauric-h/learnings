package edu.campnum.warriors.repositories;

import edu.campnum.warriors.board.Cell;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CellRepository extends CrudRepository<Cell, Long> {
    Cell findByCellNumber(int cellNumber);
}
