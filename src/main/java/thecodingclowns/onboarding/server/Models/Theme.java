package thecodingclowns.onboarding.server.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="theme_table")
public class Theme {
    
    @Id
    @Column(name = "theme_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "theme_title", nullable = false)
    private String title;

    public Theme() {}
    
    public Theme(Integer id, String title) {
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
