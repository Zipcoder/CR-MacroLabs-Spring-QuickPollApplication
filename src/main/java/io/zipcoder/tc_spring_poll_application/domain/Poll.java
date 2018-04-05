package io.zipcoder.tc_spring_poll_application.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Poll {

        @Id
        @GeneratedValue
        @Column(name  = "POLL_ID")
        long id;

        @Column(name = "QUESTION")
        String question;


        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name = "POLL_ID")
        @OrderBy
        Set<Option> option;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<Option> getOption() {
        return option;
    }

    public void setOption(Set<Option> option) {
        this.option = option;
    }
}


