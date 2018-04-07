package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.domain.Vote;
import io.zipcoder.tc_spring_poll_application.dtos.OptionCount;
import io.zipcoder.tc_spring_poll_application.dtos.VoteResult;
import io.zipcoder.tc_spring_poll_application.repositories.VoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ComputeResultController {
    @Inject
    private VoteRepository voteRepository;

    @RequestMapping(value = "/computeresult", method = RequestMethod.GET)
    public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepository.findVotesByPoll(pollId);
        int counter = 0;
        Map<Long, OptionCount> tempMap = new HashMap<>(); // create new hashmap that contains the long id and option count that contains long id and count
        for (Vote v: allVotes) { // for every vote add to the counter
            counter++;
            OptionCount optionCount = tempMap.get(v.getOption().getId()); // assign the option count to the id of the vote's option
            if(optionCount == null){
                optionCount = new OptionCount(); // if we dont have that option then create it
                optionCount.setOptionId(v.getOption().getId());
                tempMap.put(v.getOption().getId(), optionCount);
            }
            optionCount.setCount(optionCount.getCount()+1); // then set the count
        }
        voteResult.setTotalVotes(counter); // set the total votes to the counter we created
        voteResult.setResults(tempMap.values()); // get the values of the results
        return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);
    }
}

