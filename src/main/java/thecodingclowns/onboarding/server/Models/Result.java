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
    private Boolean chosenAnswer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Result() {}

    public Result(Integer id, Boolean chosenAnswer, Test test, User user) {
        this.id = id;
        this.chosenAnswer = chosenAnswer;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getChosenAnswer() {
        return chosenAnswer;
    }

    public void setChosenAnswer(Boolean chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
 

}
