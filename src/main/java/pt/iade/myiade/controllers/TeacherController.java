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

import pt.iade.myiade.models.Teacher;
import pt.iade.myiade.models.exceptions.NotFoundException;
//import pt.iade.myiade.models.responses.Response;
import pt.iade.myiade.models.repositories.TeacherRepository;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/api/teachers")
public class TeacherController{
    
    private Logger logger = LoggerFactory.getLogger(TeacherController.class);
    @Autowired
    private TeacherRepository teacherRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Teacher> getAllTeachers()
    {
        logger.info("Teachers info: ");
        return teacherRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces=
    MediaType.APPLICATION_JSON_VALUE)
    public Teacher getTeacherInfo(@PathVariable int id) 
    {
        logger.info("Sending teacher with id " + id);
        Optional<Teacher> _teacher = teacherRepository.findById(id);
        if (_teacher.isEmpty())
        throw new NotFoundException("" + id, "Teacher", "id");
        else return _teacher.get();
    }
}
