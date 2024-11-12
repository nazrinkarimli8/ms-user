package az.edu.turing.msuser.model.dto;

import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        String fin,
        String fullName,
        String password
) {
}
