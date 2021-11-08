package pt.iade.myiade.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.myiade.models.Iade;
import pt.iade.myiade.models.exceptions.NotFoundException;
import pt.iade.myiade.models.repositories.IadeRepository;
import pt.iade.myiade.models.responses.Response;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/api/testeiade")
public class IadeController{
    
    private Logger logger = LoggerFactory.getLogger(IadeController.class);
    @Autowired
    private IadeRepository iadeRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Iade> getUnits()
    {
        logger.info("Sending all units");
        return iadeRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces=
    MediaType.APPLICATION_JSON_VALUE)
    public Iade getUnit(@PathVariable int id) 
    {
        logger.info("Sending unit with id " + id);
        Optional<Iade> _iade = iadeRepository.findById(id);
        if (_iade.isEmpty())
        throw new NotFoundException("" + id, "Unit", "id");
        else return _iade.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iade saveUnit(@RequestBody Iade unit) {
        Iade savedUnit = iadeRepository.save(unit);
        logger.info("Saving unit with id " + savedUnit.getId());
        return savedUnit;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces =
    MediaType.APPLICATION_JSON_VALUE)
    public Response deleteUnit(@PathVariable int id) {
        logger.info("Deleting unit with id " + id);
        // No verification to see if it exists
        iadeRepository.deleteById(id);
        return new Response("Deleted unit with id " + id, null);
    }
}

