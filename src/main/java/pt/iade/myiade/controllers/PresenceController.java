package pt.iade.myiade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import pt.iade.myiade.models.Presence;
import pt.iade.myiade.models.repositories.PresenceRepository;
import pt.iade.myiade.models.responses.Response;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/api/presences")
public class PresenceController{
    
    private Logger logger = LoggerFactory.getLogger(PresenceController.class);
    @Autowired
    private PresenceRepository presenceRepository;
    @PostMapping(path = "/{presenceStudentID}/{presenceScheduleID}")
    public Response registerStudent(@PathVariable int presenceStudentID, @PathVariable int presenceScheduleID) {
    
        logger.info("Registering presence ");

        Integer inserted = presenceRepository.registerPresence(presenceScheduleID, presenceStudentID, LocalDate.now());
        return new Response(" presence registered -> ", inserted);
    }
}
