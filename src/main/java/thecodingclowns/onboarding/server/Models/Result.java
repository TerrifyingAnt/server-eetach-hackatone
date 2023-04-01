package thecodingclowns.onboarding.server.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="result_table")
public class Result {
    
    @Id
    @Column(name = "result_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "result_choosen_answer", nullable = false)
    private Integer chosenAnswer;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Result(Integer id, Integer chosenAnswer, Test test, User user) {
        this.id = id;
        this.chosenAnswer = chosenAnswer;
        this.test = test;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChosenAnswer() {
        return chosenAnswer;
    }

    public void setChosenAnswer(Integer chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
 

}
