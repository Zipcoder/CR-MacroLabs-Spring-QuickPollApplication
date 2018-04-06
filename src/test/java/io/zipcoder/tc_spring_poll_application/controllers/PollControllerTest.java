package io.zipcoder.tc_spring_poll_application.controllers;

import io.zipcoder.tc_spring_poll_application.domain.Poll;
import io.zipcoder.tc_spring_poll_application.repositories.PollRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * project: spring-demo
 * package: io.zipcoder.tc_spring_poll_application.controllers
 * author: https://github.com/vvmk
 * date: 4/5/18
 */
public class PollControllerTest {

    @InjectMocks
    private PollController pollCtrl;

    @Mock
    private PollRepository pollRepo;

    private List<Poll> polls = new ArrayList<>();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        // GET all polls
        when(pollRepo.findAll()).thenReturn(polls);

        //POST create poll
        when(pollRepo.save(any(Poll.class))).thenAnswer(inv -> inv.getArgument(0));

//        when(pollRepo::save)
//                .onSuccess(HttpStatus.CREATED)
//                .onFail(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void getAllPollsReturnsIterable() {
        Class<?> expected = Iterable.class;
        Class<?> actual = pollCtrl.getAllPolls().getBody().getClass();

        verify(pollRepo).findAll();
        Assert.isAssignable(expected, actual);
    }

    @Test
    public void getAllPollsReturnsPolls() {
        polls.add(mock(Poll.class));

        long expected = 1;
        long actual = pollCtrl.getAllPolls().getBody().spliterator().getExactSizeIfKnown();

        verify(pollRepo).findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void createPollSavesPoll() {
        Poll expected = new Poll();
        expected.setId(1L);

        Poll actual = pollCtrl.createPoll(expected).getBody();

        verify(pollRepo).save(any(Poll.class));
        assertEquals(expected.getId(), actual.getId());
    }

    @Test
    public void createPollReturnsLocation() {
        Poll p = new Poll();
        p.setId(1L);

        Pattern expected = Pattern.compile("/polls/1");
        String actual = pollCtrl.createPoll(p).getHeaders().getLocation().toString();

        verify(pollRepo).save(any(Poll.class));
        assertTrue(expected.matcher(actual).find());
    }
}