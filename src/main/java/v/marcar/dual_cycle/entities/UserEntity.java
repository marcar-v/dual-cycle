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
    @Column(name = "id", nullable = false, length = 64)
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "passHash", nullable = false, length = 64)
    private String passHash;
    @Column(name = "year", nullable = true)
    private int year;
    @Column(name = "genre", nullable = true, length = 32)
    private String genre;

    protected UserEntity() {}

    public UserEntity(String id, String name, String email, String passHash) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passHash = passHash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
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
