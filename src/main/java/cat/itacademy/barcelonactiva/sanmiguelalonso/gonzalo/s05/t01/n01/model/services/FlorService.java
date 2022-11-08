package cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.services;


import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlorService implements IFlorService {

    @Autowired
    private FlorRepository florRepository;


    @Override
    public List<FlorDTO> getAllFlowers() {

        Iterable<FlorEntity> florEntityList = florRepository.findAll();
        List<FlorDTO> florDTOList = new ArrayList<>();
        for (FlorEntity f : florEntityList
        ) {
            FlorDTO newFlorDTO = getFlorDTO(f);
            florDTOList.add(newFlorDTO);
        }
        return florDTOList;
    }


    @Override
    public FlorEntity addFlower(FlorDTO newFlorDTO) {

        FlorEntity newFlorEntity = new FlorEntity();
        newFlorEntity.setNomFlor(newFlorDTO.getNomFlor());
        newFlorEntity.setPaisFlor(newFlorDTO.getPaisFlor());
        return florRepository.save(newFlorEntity);
    }


    @Override
    public void delete(int pkId) throws EmptyResultDataAccessException {
        florRepository.deleteById(pkId);
    }


    @Override
    public void updateFlower(FlorDTO florToUpdate) throws EntityNotFoundException{

        Optional<FlorEntity> florEntityResponse = florRepository.findById(florToUpdate.getPk_FlorID());

        if (florEntityResponse.isPresent()) {
            florEntityResponse.get().setNomFlor(florToUpdate.getNomFlor());
            florEntityResponse.get().setPaisFlor(florToUpdate.getPaisFlor());

            florRepository.save(florEntityResponse.get());

        } else {

             throw new EntityNotFoundException("No em trobat cap flor amb id: " + florToUpdate.getPk_FlorID());
        }
    }


    @Override
    public FlorDTO getOne(int pkId) throws EntityNotFoundException {

        Optional<FlorEntity> sucursalResponse = florRepository.findById(pkId);
        FlorDTO sucursal = null;

        if (sucursalResponse.isPresent()) {
            sucursal = getFlorDTO(sucursalResponse.get());

        } else {
            throw new EntityNotFoundException("No em trobat cap flor amb id: " + pkId);
        }

        return sucursal;
    }


    private FlorDTO getFlorDTO(FlorEntity f) {

        FlorDTO newFlorDTO = new FlorDTO();
        newFlorDTO.setPk_FlorID(f.getPk_FlorID());
        newFlorDTO.setNomFlor(f.getNomFlor());
        newFlorDTO.setPaisFlor(f.getPaisFlor());
        newFlorDTO.setTipusFlor(f.getPaisFlor());
        return newFlorDTO;
    }


}
