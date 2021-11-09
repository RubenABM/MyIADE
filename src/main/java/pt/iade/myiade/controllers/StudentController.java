package pt.iade.myiade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.myiade.models.Student;
import pt.iade.myiade.models.exceptions.NotFoundException;
import pt.iade.myiade.models.repositories.StudentRepository;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path = "/api/courses")
public class StudentController
{
    private Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentRepository StudentRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Student> getCourses()
    {
        logger.info("Sending all courses");
        return StudentRepository.findAll();
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getCourseById(@PathVariable int id)
    {
        logger.info("Sending all courses");
        Optional<Student> _course = StudentRepository.findById(id);
        if(_course.isPresent()) return _course.get();
        else throw new NotFoundException(""+id, "Course", "id");
    }

}
