package dev.project.airline.profile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.project.airline.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private Long id;

    private String firstName;
    private String lastName;
    private String dni;
    private String img;

    @Column(unique = true)
    private String email;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private User user;

    public Profile() {
    }

    public Profile(String firstName, String lastName, String dni, String img, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.img = img;
        this.email = email;
    }

    public Profile(Long id, String firstName, String lastName, String dni, String img, String email, User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.img = img;
        this.email = email;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
        
}
