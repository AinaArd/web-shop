package ru.itis.webshop.services;

import ru.itis.webshop.dto.UserDto;
import ru.itis.webshop.models.User;

public interface UserService {
    UserDto getUserDtoById(Long userId);

    User findUserById(Long userId);

    UserDto signUp(UserDto userDto);

    UserDto signIn(UserDto userDto);
}
