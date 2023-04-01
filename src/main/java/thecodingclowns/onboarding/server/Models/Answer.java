package thecodingclowns.onboarding.server.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "answer_table")
public class Answer {
    
    @Id
    @Column(name = "answer_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "answer_title", nullable = false)
    private String title;

    public Answer(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
}
