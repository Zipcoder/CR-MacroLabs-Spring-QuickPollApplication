package io.zipcoder.tc_spring_poll_application.repositories;
import org.springframework.data.repository.CrudRepository;
import io.zipcoder.tc_spring_poll_application.domain.Vote;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {
}
