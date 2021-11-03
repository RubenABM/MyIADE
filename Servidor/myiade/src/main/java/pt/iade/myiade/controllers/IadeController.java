package pt.iade.myiade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.myiade.models.Iade;
import pt.iade.myiade.models.repositories.IadeRepository;

import org.springframework.http.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/api/Iade")
public class IadeController
{
    private Logger logger = LoggerFactory.getLogger(IadeController.class);
    @Autowired
    private IadeRepository iadeRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Iade> getID() {
    logger.info("Sending all units");
    return iadeRepository.findAll();
    }

}
