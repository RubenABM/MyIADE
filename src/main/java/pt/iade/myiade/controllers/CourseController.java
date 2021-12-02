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

import pt.iade.myiade.models.Course;
import pt.iade.myiade.models.exceptions.NotFoundException;
import pt.iade.myiade.models.repositories.CourseRepository;
//import pt.iade.myiade.models.responses.Response;
import pt.iade.myiade.models.views.StudentCourseView;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/api/courses")
public class CourseController{
    
    private Logger logger = LoggerFactory.getLogger(CourseController.class);
    @Autowired
    private CourseRepository courseRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Course> getAllCourses()
    {
        logger.info("Courses info: ");
        return courseRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces=
    MediaType.APPLICATION_JSON_VALUE)
    public Course getCourseInfo(@PathVariable int id) 
    {
        logger.info("Sending course with id " + id);
        Optional<Course> _course = courseRepository.findById(id);
        if (_course.isEmpty())
        throw new NotFoundException("" + id, "Course", "id");
        else return _course.get();
    }

    @GetMapping(path = "/studentscourse")
    public Iterable<StudentCourseView> getStudentsCourses() 
    {
        logger.info("Sending all students and courses");
        return courseRepository.findAllStudentsCourses();
    }

    @GetMapping(path="/studentscourse/{id}")
    public Iterable<StudentCourseView> getStudentCourse(@PathVariable int id) 
    {
        logger.info("Student course with student id " + id);
        return courseRepository.findStudentCourseByID(id);
    }
}
