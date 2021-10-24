package pt.iade.myiade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.myiade.models.repositories.IadeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/api/pathexemplo")
public class IadeController
{
    private Logger logger = LoggerFactory.getLogger(IadeController.class);
    @Autowired
    private IadeRepository CourseRepository;
}
