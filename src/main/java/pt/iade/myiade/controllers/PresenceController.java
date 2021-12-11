package pt.iade.myiade.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.iade.myiade.models.repositories.PresenceRepository;
import pt.iade.myiade.models.responses.Response;

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
