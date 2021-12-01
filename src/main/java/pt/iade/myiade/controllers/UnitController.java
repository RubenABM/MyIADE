package pt.iade.myiade.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.myiade.models.Unit;
import pt.iade.myiade.models.exceptions.NotFoundException;
import pt.iade.myiade.models.repositories.UnitRepository;
//import pt.iade.myiade.models.responses.Response;
import pt.iade.myiade.models.views.UnitCoursesView;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/api/units")
public class UnitController{
    
    private Logger logger = LoggerFactory.getLogger(UnitController.class);
    @Autowired
    private UnitRepository unitRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Unit> getAllUnits()
    {
        logger.info("Units info: ");
        return unitRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces=
    MediaType.APPLICATION_JSON_VALUE)
    public Unit getUnitInfo(@PathVariable int id) 
    {
        logger.info("Sending unit with id " + id);
        Optional<Unit> _unit = unitRepository.findById(id);
        if (_unit.isEmpty())
        throw new NotFoundException("" + id, "Unit", "id");
        else return _unit.get();
    }

    @GetMapping(path = "/unitcourse")
    public Iterable<UnitCoursesView> getUnitsAndCourses() 
    {
        logger.info("Sending all courses and units");
        return unitRepository.findAllUnitsCourses();
    }

    @GetMapping(path="/unitcourse/{course}")
    public Iterable<UnitCoursesView> getUnitsbyCourse(@PathVariable String course) 
    {
        logger.info("Units with course " + course);
        return unitRepository.findUnitsByCourse(course);
    }
}