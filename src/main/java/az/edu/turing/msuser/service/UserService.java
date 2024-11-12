package az.edu.turing.msuser.service;

import az.edu.turing.msuser.model.dto.UserRequest;
import az.edu.turing.msuser.model.dto.UserResponse;

import java.util.Optional;

public interface UserService {
    void deleteAll();

    void deleteById(Long id);

    UserResponse update(Long id, UserRequest userDto);

    Optional<UserResponse> getByFin(String fin);
}
