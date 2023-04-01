package thecodingclowns.onboarding.server.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "task_variant_table")
public class TaskVariant {
    
    @Id
    @Column(name = "task_variant_id", nullable = false, unique = true)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "task_variant_right", nullable = false)
    private Boolean isTrue;

    @Column(name = "task_variant_score", nullable = false)
    private Integer score;

    public TaskVariant() {}
    
    public TaskVariant(Integer id, Question question, Boolean isTrue, Integer score) {
        this.id = id;
        this.question = question;
        this.isTrue = isTrue;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Boolean getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(Boolean isTrue) {
        this.isTrue = isTrue;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    
}
