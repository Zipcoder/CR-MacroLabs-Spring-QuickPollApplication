package io.zipcoder.tc_spring_poll_application.Repositories;

import io.zipcoder.tc_spring_poll_application.Domain.Vote;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Long> {
}
