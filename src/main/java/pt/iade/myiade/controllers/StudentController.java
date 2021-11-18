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

import pt.iade.myiade.models.Student;
import pt.iade.myiade.models.exceptions.NotFoundException;
import pt.iade.myiade.models.repositories.StudentRepository;
//import pt.iade.myiade.models.responses.Response;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController{
    
    private Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Student> getAllStudent()
    {
        logger.info("Students info: ");
        return studentRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces=
    MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentInfo(@PathVariable int id) 
    {
        logger.info("Sending student with id " + id);
        Optional<Student> _student = studentRepository.findById(id);
        if (_student.isEmpty())
        throw new NotFoundException("" + id, "Student", "id");
        else return _student.get();
    }

    @GetMapping(path = "/{email}/{password}", produces=
    MediaType.APPLICATION_JSON_VALUE)
    public int getStudentInfoByEmail(@PathVariable String email, @PathVariable String password) 
    {
        logger.info("Sending student with email " + email + " and password " + password);
        Optional<Student> _student = studentRepository.findByEmailAndPassword(email, password);
        if (_student.isEmpty())
        throw new NotFoundException("" + email , "Student", "id");
        else return _student.get().getId();
    }
}

