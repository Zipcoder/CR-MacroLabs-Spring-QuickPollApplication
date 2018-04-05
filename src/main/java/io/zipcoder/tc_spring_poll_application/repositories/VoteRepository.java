package io.zipcoder.tc_spring_poll_application.repositories;

import io.zipcoder.tc_spring_poll_application.domain.Vote;
import org.springframework.data.repository.CrudRepository;

/**
 * project: spring-demo
 * package: io.zipcoder.tc_spring_poll_application.repositories
 * author: https://github.com/vvmk
 * date: 4/5/18
 */
public interface VoteRepository extends CrudRepository<Vote, Long> {
}
