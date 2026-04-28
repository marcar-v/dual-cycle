package v.marcar.dual_cycle.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
        name = "events",
        indexes = {
                @Index(name = "idx_type", columnList = "type"),
                @Index(name = "idx_date", columnList = "date"),
                @Index(name = "idx_userID", columnList = "userID")
        }
)
public class EventEntity {
    @Id
    @Column(name = "id", nullable = false, length = 64)
    private String id;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "authorID", nullable = false)
    private UserEntity author;
    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private UserEntity user;

    protected EventEntity() {}

    public EventEntity(String id, String type, LocalDate date, UserEntity author, UserEntity user){
        this.id = id;
        this.type = type;
        this.date = date;
        this.author = author;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity authorID) {
        this.author = authorID;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity userID) {
        this.user = userID;
    }
}
