package thecodingclowns.onboarding.server.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "test_table")
public class Test {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_note_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "test_id", nullable = false)
    private Integer testId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_variant_id")
    private TaskVariant taskVariant;

    public Test() {}

    public Test(Integer id, Integer testId, TaskVariant taskVariant) {
        this.id = id;
        this.testId = testId;
        this.taskVariant = taskVariant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public TaskVariant getTaskVariant() {
        return taskVariant;
    }

    public void setTaskVariant(TaskVariant taskVariant) {
        this.taskVariant = taskVariant;
    }

    
}
