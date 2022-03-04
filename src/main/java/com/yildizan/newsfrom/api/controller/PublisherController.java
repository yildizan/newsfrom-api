package com.yildizan.newsfrom.api.controller;

import com.yildizan.newsfrom.api.model.Publisher;
import com.yildizan.newsfrom.api.repository.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/publisher")
public class PublisherController {

    private static final Logger log = LoggerFactory.getLogger("error");

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping(path="/list")
    public List<Publisher> list() {
        List<Publisher> result = new ArrayList<>();

        for(var publisher : publisherRepository.findAll()) {
            Publisher model = new Publisher();
            model.setId(publisher.getId());
            model.setName(publisher.getName());
            result.add(model);
        }

        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handle(Exception e) {
        log.error("exception: ", e);
    }
}
