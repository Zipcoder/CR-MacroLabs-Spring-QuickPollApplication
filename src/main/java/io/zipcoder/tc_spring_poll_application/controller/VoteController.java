package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.domain.Vote;
import io.zipcoder.tc_spring_poll_application.repositories.VoteRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;

@RestController
public class VoteController {

        @Inject
        private VoteRepository voteRepository;

        @RequestMapping(value = "/polls/{pollId}/votes", method = RequestMethod.POST)
        public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote
                vote) {
            vote = voteRepository.save(vote);
            // Set the headers for the newly created resource
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setLocation(ServletUriComponentsBuilder.
                    fromCurrentRequest().path("/{id}").buildAndExpand(vote.getId()).toUri());
            return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
        }


    public interface VoteRepository extends CrudRepository<Vote, Long> {
        @Query(value = "SELECT v.* " +
                "FROM Option o, Vote v " +
                "WHERE o.POLL_ID = ?1 " +
                "AND v.OPTION_ID = o.OPTION_ID", nativeQuery = true)
        public Iterable<Vote> findVotesByPoll(Long pollId);
    }

}


