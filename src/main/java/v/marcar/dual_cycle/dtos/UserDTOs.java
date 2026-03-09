package v.marcar.dual_cycle.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTOs {
    public record CreateUserRequest(
            @NotBlank @Size(max = 255) String name,
            @NotBlank @Email @Size(max = 255) String email,
            @NotBlank @Size(min = 8, max = 64) String password,
            @Size(max = 32) String genre,
            int year
    ) {}

    public record CreateUserResponse(
            String id,
            String name,
            String email,
            String  genre,
            int year
    ) {}

    public record UpdateUserRequest(
            @Size(max = 32) String genre,
            int year
    ) {}

    public record UpdateUserResponse(
            String genre,
            int year
    ) {}
}
