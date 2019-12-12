package io.zipcoder.tc_spring_poll_application.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Poll {
    @Id
    @GeneratedValue//(strategy = GenerationType.AUTO)
    @Column(name = "POLL_ID")
    private Long id;

    @NotEmpty
    @Column(name = "QUESTION")
    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    @Size(min=2, max=6)
    @JoinColumn(name = "POLL_ID")
    @OrderBy
    private Set<Option> options;

//    public Poll() {}
//    public Poll(String question, Set options) {
//        this.question = question;
//        this.options = options;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }
}
