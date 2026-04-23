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
    @Id
    @JoinColumn(name = "authorID", nullable = false)
    private UserEntity authorID;
    @ManyToOne
    @Id //¿Esto es necesario?
    @JoinColumn(name = "userID", nullable = false)
    private UserEntity userID;

    protected EventEntity() {}

    public EventEntity(String id, String type, LocalDate date, UserEntity authorID, UserEntity userID){
        this.id = id;
        this.type = type;
        this.date = date;
        this.authorID = authorID;
        this.userID = userID;
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

    public UserEntity getAuthorID() {
        return authorID;
    }

    public void setAuthorID(UserEntity authorID) {
        this.authorID = authorID;
    }

    public UserEntity getUserID() {
        return userID;
    }

    public void setUserID(UserEntity userID) {
        this.userID = userID;
    }
}
