package az.edu.turing.msuser.service.impl;

import az.edu.turing.msuser.mapper.UserMapper;
import az.edu.turing.msuser.model.dto.UserRequest;
import az.edu.turing.msuser.model.dto.UserResponse;
import az.edu.turing.msuser.service.UserService;
import az.edu.turing.msuser.domain.entity.UserEntity;
import az.edu.turing.msuser.domain.repository.UserRepository;
import az.edu.turing.msuser.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void create(UserRequest userDto) {
        UserEntity userEntity = userMapper.toUserEntity(userDto);
        userRepository.save(userEntity);
    }

    @Override
    public Optional<UserResponse> getByFin(String fin) {
        UserEntity userEntity = userRepository.findByFin(fin)
                .orElseThrow(() -> new UserNotFoundException("User not found with fin: " + fin));
        return Optional.of(userMapper.toUserDto(userEntity));
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse update(Long id, UserRequest userDto) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        userEntity.setFullName(userDto.getFullName());
        userRepository.save(userEntity);

        return userMapper.toUserDto(userEntity);
    }
}
