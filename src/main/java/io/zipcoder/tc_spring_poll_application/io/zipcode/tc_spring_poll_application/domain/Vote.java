package io.zipcoder.tc_spring_poll_application.io.zipcode.tc_spring_poll_application.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vote {

    @Id
    @GeneratedValue
    @Column(name = "VOTE_ID")
    Long id;

}
