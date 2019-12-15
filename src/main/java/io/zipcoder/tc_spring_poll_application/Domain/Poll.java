package io.zipcoder.tc_spring_poll_application.Domain;
import javax.persistence.*;
import java.util.Set;


@Entity
public class Poll {
    @Id
    @GeneratedValue
    @Column(name = "POLL_ID")
    Long id;

    @Column(name = "QUESTION")
    String question;

    @OrderBy
    @JoinColumn(name = "POLL_ID")
    @OneToMany(cascade = CascadeType.ALL)
    Set<Option> options;

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }
}
