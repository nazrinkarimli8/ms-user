package az.edu.turing.msuser.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//public record UserRequest (
//        @NotBlank
//        String fullName,
//
//        @NotBlank
//        String fin,
//
//        @NotBlank
//        String password,
//
//        @NotBlank
//        String email
//)
//{
//}

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

        @NotBlank
        private String fullName;

        @NotBlank
        private String fin;

        @NotBlank
        private String password;

        @NotBlank
        private String email;
}
