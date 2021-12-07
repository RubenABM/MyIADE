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
import pt.iade.myiade.models.exceptions.NotFoundException2;
import pt.iade.myiade.models.repositories.StudentRepository;
//import pt.iade.myiade.models.responses.Response;
import pt.iade.myiade.models.views.GradesView;
import pt.iade.myiade.models.views.PresenceView;
import pt.iade.myiade.models.views.ResourceView;
import pt.iade.myiade.models.views.ScheduleView;

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

    @GetMapping(path = "/login/{email}/{password}", produces=
    MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentInfoByEmailAndPassword(@PathVariable String email, @PathVariable String password) 
    {
        logger.info("Sending student with email " + email + " and password " + password);
        Optional<Student> _student = studentRepository.findByEmailAndPassword(email, password);
        if (_student.isEmpty())
        throw new NotFoundException2("" + email , "Student", "email", password);
        else return _student.get();
    }

    @GetMapping(path = "/grades")
    public Iterable<GradesView> getStudentsGrades() 
    {
        logger.info("Sending all students and grades");
        return studentRepository.findAllStudentsGrades();
    }

    @GetMapping(path="/grades/{id}")
    public Iterable<GradesView> getStudentGradesByID(@PathVariable int id) 
    {
        logger.info("Grades with student id: " + id);
        return studentRepository.findStudentGradesByID(id);
    }

    @GetMapping(path="/schedule/{id}/{semester}")
    public Iterable<ScheduleView> getStudentSchedule(@PathVariable int id, @PathVariable int semester) 
    {
        logger.info("Schedule with student id: " + id + " and semester: " + semester);
        return studentRepository.findStudentSchedule(id, semester);
    }
    
    @GetMapping(path="/resource/{id}")
    public Iterable<ResourceView> getStudentResource(@PathVariable int id) 
    {
        logger.info("Resource with student id: " + id);
        return studentRepository.findStudentResource(id);
    }

    @GetMapping(path="/presence/{id}")
    public Iterable<PresenceView> getStudentPresence(@PathVariable int id) 
    {
        logger.info("Presence with student id: " + id);
        return studentRepository.findStudentPresence(id);
    }
}

