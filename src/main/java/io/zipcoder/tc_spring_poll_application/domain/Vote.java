package io.zipcoder.tc_spring_poll_application.domain;

import javax.persistence.*;

/**
 * project: spring-demo
 * package: io.zipcoder.tc_spring_poll_application.domain
 * author: https://github.com/vvmk
 * date: 4/5/18
 */
@Entity
public class Vote {

    @Id
    @GeneratedValue
    @Column(name="VOTE_ID")
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    @ManyToOne
    @JoinColumn(name="OPTION_ID")
    private Option option;
}
