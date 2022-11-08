package cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.dto.FlorDTO;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface IFlorService {

    // Method showing all the records
    List<FlorDTO> getAllFlowers();
    // Method for saving a record
    FlorEntity addFlower(FlorDTO newFlorEntity);
    // Method to delete a record
    void delete(int id) throws EntityNotFoundException;
    // Method returning a record requested
    FlorDTO getOne(int id) throws RuntimeException;
    // Method to update a record requested
    void updateFlower(FlorDTO updateFlor);
}
