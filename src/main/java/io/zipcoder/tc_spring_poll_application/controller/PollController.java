package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.repositories.PollRepository;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class PollController {

    @Inject
    private PollRepository pollRepository;

}
