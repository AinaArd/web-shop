package ru.itis.webshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.webshop.dto.UserDto;
import ru.itis.webshop.models.User;
import ru.itis.webshop.repositories.UserRepository;
import ru.itis.webshop.services.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUserDtoById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return UserDto.from(userOptional.get());
        } else {
            return UserDto.empty();
        }
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public UserDto signUp(UserDto userDto) {
        User newUser = User.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .build();
        return UserDto.from(userRepository.save(newUser));
    }

    @Override
    public UserDto signIn(UserDto userDto) {
        Optional<User> userOptional = userRepository.findByLoginAndPassword(userDto.getLogin(), userDto.getPassword());
        if (userOptional.isPresent()) {
            return UserDto.from(userOptional.get());
        } else {
            return UserDto.empty();
        }
    }
}
