package com.ffivrpportal.service;


import com.ffivrpportal.dto.UserDto;
import com.ffivrpportal.model.User;

import java.util.List;

public interface UserService {

    User findByEmail(String email);

    void saveUser(UserDto userDto);

    List<UserDto> findAllUsers();

    List<UserDto> findAllSuperUsers();

    void updateUser(UserDto userDto, User user);

    UserDto findById(Long id);

    void deleteById(Long id);
}