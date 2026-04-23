package v.marcar.dual_cycle.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class EventDTO {
    public record CreateEventRequest(
            @NotBlank String type,
            @NotBlank @PastOrPresent LocalDate date,
            @NotBlank String idk //¿id, userID, authorId? Follón tremendo
            ){}

    public record CreateEventResponse(
            String id,
            String type,
            LocalDate date,
            String authorID,
            String userID
    ) {}
}
