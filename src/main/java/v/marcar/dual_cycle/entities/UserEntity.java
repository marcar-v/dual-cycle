package v.marcar.dual_cycle.entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name="uq_users_email", columnNames = "email")
        }
)
public class UserEntity {
    @Id
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "year", nullable = true)
    private int year;
    @Column(name = "genre", nullable = true, length = 32)
    private String genre;

    protected UserEntity() {}

    public UserEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
