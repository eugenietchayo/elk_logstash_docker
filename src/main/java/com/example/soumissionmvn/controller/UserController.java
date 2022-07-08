package com.example.soumissionmvn.controller;

import com.example.soumissionmvn.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.GregorianCalendar;

@Slf4j
@Controller
public class UserController {

    @RequestMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(required = true) final Long id) {

        log.info("Request with the id =[" + id + "]");

        final User user = new User(id, "firstname", "surname", new GregorianCalendar());
        log.info(String.format("id=[%s] firstname=[%s] surname=[%s]", user.getId(), user.getFirstname(), user.getSurname()));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
