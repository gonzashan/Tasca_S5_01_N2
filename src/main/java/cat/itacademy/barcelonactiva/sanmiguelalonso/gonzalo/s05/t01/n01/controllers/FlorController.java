package cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.controllers;


import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.exception.ErrorDetails;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.exception.Message;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.exception.RequestOk;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.repository.FlorRepository;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.services.IFlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RestController
@RequestMapping("/flor")
public class FlorController {

    @Autowired
    private IFlorService florService;
    @Autowired
    private FlorRepository florRepository;


    /**
     * GET -> /flor/getAll
     * @return ResponseEntity
     */
    @GetMapping(value = "/getAll")
    public List<FlorDTO> getAllFlowers() {
        return florService.getAllFlowers();
    }


    /**
     * GET -> /flor/getOne/{id}
     * @return ResponseEntity
     */
    @RequestMapping(value = "/getOne/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<? extends Object> getOne(@PathVariable int id) {
        try {
            FlorDTO surcursalResponse = florService.getOne(id);
            return new ResponseEntity<FlorDTO>(surcursalResponse, HttpStatus.OK);

        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<ErrorDetails>(
                    new ErrorDetails(HttpStatus.NOT_FOUND.value(),
                            "El id: " + id + " no se ha trobat"),
                    HttpStatus.NOT_FOUND);
        }
    }


    /**
     * POST -> /flor/add
     * @return ResponseEntity
     */
    @PostMapping(path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<?> create(@RequestBody FlorDTO florNueva) {
        FlorEntity nueva = florService.addFlower(florNueva);
        try {
            if (nueva == null) {
                return new ResponseEntity<ErrorDetails>
                        (new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                "No se ha pogut guardar la flor nova."),
                                HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<RequestOk>
                        (new RequestOk("La flor " + nueva.getNomFlor()
                                + " se ha introduït correctament."),
                                HttpStatus.CREATED);
            }
        } catch (HttpMessageNotWritableException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    /**
     * DELETE -> /flor/delete/{id}
     * @return ResponseEntity
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public HttpEntity<? extends Message> deleteFlor(@PathVariable int id) {

        try {
            String florDeleted = florService.getOne(id).getNomFlor();
            florService.delete(id);
            return new ResponseEntity<RequestOk>
                    (new RequestOk(florDeleted + " s'has eliminat correctament."), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<ErrorDetails>(
                    new ErrorDetails(HttpStatus.NOT_FOUND.value(),
                            "El id: " + id + " no se ha trobat")
                    , HttpStatus.NOT_FOUND);
        }
    }


    /**
     * PUT -> /flor/update
     * @return ResponseEntity
     */
    @PutMapping(path = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<? extends Message> update(@RequestBody FlorDTO updateFlor) {

        if (updateFlor == null) {
            return new ResponseEntity<ErrorDetails>
                    (new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            "No se ha pogut modificar el registre")
                            , HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            try {
                florService.updateFlower(updateFlor);
                return new ResponseEntity<RequestOk>
                        (new RequestOk("La flor " + updateFlor.getNomFlor()
                                + " se ha modificat correctament.")
                                , HttpStatus.CREATED);

            } catch (Exception e) {
                return new ResponseEntity<ErrorDetails>(
                        new ErrorDetails(HttpStatus.NOT_FOUND.value(),
                                "El id: " + updateFlor.getPk_FlorID() + " no se ha trobat")
                        , HttpStatus.NOT_FOUND);
            }
        }
    }


}
