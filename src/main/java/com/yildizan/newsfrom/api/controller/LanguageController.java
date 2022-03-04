package com.yildizan.newsfrom.api.controller;

import com.yildizan.newsfrom.api.model.Language;
import com.yildizan.newsfrom.api.repository.LanguageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/language")
public class LanguageController {

    private static final Logger log = LoggerFactory.getLogger("error");

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping(path="/list")
    public List<Language> list() {
        List<Language> result = new ArrayList<>();

        for(var language : languageRepository.findAll()) {
            Language model = new Language();
            model.setId(language.getId());
            model.setName(language.getName());
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
