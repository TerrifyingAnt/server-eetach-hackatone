package thecodingclowns.onboarding.server.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profession_table")
public class Profession {

    @Id
    @Column(name = "profession_id", nullable = false, unique = true)
    private Integer id;

    @Column(name ="profession_title", nullable = false)
    private String title;

    public Profession(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Profession() {}

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
