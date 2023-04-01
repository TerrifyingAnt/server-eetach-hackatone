package thecodingclowns.onboarding.server.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
    
    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "user_full_name", nullable = false)
    private String fullName;

    @Column(name = "user_rating", nullable = false)
    private Integer rating;

    @Column(name = "user_phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "user_vk_link", nullable = true)
    private String vkLink;

    @Column(name = "user_tg_link", nullable = true)
    private String tgLink;

    @Column(name = "user_password", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_profession_id")
    private Profession profession;

    
    public User(Integer id, String fullName, Integer rating, String phoneNumber, String email, String vkLink,
            String tgLink, String password) {
        this.id = id;
        this.fullName = fullName;
        this.rating = rating;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.vkLink = vkLink;
        this.tgLink = tgLink;
        this.password = password;
    }

    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVkLink() {
        return vkLink;
    }

    public void setVkLink(String vkLink) {
        this.vkLink = vkLink;
    }

    public String getTgLink() {
        return tgLink;
    }

    public void setTgLink(String tgLink) {
        this.tgLink = tgLink;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
