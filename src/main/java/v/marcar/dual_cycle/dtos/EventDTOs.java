package v.marcar.dual_cycle.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class EventDTOs {
    public record CreateEventRequest(
            @NotBlank String type,
            @NotNull @PastOrPresent LocalDate date,
            @NotBlank String userID
            ){}

    public record CreateEventResponse(
            String id,
            String type,
            LocalDate date,
            UserDTOs.GetUserResponse author,
            UserDTOs.GetUserResponse user
    ) {}

    public record GetEventResponse(
            String id,
            String type,
            LocalDate date,
            UserDTOs.GetUserResponse author,
            UserDTOs.GetUserResponse user
    ) {}

    public record GetEventsResponse(
            List<GetEventResponse> events
    ) {}

    public record UpdateEventRequest(
            String type,
            LocalDate date,
            UserDTOs.GetUserResponse user
    ) {}

    public record UpdateEventResponse(
            String id,
            String type,
            LocalDate date,
            UserDTOs.GetUserResponse author,
            UserDTOs.GetUserResponse user
    ) {}
}
