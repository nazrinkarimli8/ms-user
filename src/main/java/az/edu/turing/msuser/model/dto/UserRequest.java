package az.edu.turing.msuser.model.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRequest (
        @NotBlank
        String fullName,

        @NotBlank
        String fin,

        @NotBlank
        String password
)
{
}

