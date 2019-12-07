package io.zipcoder.tc_spring_poll_application.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import io.zipcoder.tc_spring_poll_application.repositories.PollRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@RestController
public class PollController {
   private PollRepository pollRepository;

   @Autowired
    public PollController(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @RequestMapping(value = "/polls", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();
        return new ResponseEntity<>(allPolls, org.springframework.http.HttpStatus.OK);
    }
}
