package io.zipcoder.tc_spring_poll_application.domain;

import javax.persistence.*;

@Entity
public class Option {
    @Id
    @GeneratedValue
    @Column(name = "OPTION_ID")
    private long id;

    @Column(name = "OPTION_VALUE")
    private String value;

    @Column(name = "POLL_ID")
    private Long pollId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
