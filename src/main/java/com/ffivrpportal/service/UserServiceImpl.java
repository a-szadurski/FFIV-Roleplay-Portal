package com.ffivrpportal.service;


import com.ffivrpportal.dto.UserDto;
import com.ffivrpportal.exception.UserAlreadyExistException;
import com.ffivrpportal.model.Role;
import com.ffivrpportal.model.User;
import com.ffivrpportal.repository.RoleRepository;
import com.ffivrpportal.repository.UserRepository;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDto findByEmailDto(String email) {
        return new UserDto(userRepository.findByEmail(email));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(UserDto userDto) {

        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: " + userDto.getEmail());
        }
        final User user = new User();
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEnabled(true);
        user.setEmail(userDto.getEmail());
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public List<UserDto> findAllUsers() {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        return userRepository.findAllByRolesIn(roles).stream()
                .map(user -> new UserDto(
                        user.getId(), user.getEmail(), user.isEnabled()
                )).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllSuperUsers() {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_ADMIN"));
        return userRepository.findAllByRolesIn(roles).stream()
                .map(user -> new UserDto(
                        user.getId(), user.getEmail(), user.isEnabled()
                )).collect(Collectors.toList());
    }

    @Override
    public void updateUser(UserDto userDto, User user) {

        updateUsername(userDto.getEmail(), user.getId());
        updatePassword(userDto.getPassword(), user);
    }

    @Override
    public UserDto findById(Long id) {

        UserDto userDto;

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            userDto = new UserDto(userOptional.get().getId(), userOptional.get().getEmail(), userOptional.get().isEnabled());
        } else {
            throw new NotFoundException("User not found");
        }

        return userDto;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User setUser(UserDto userDto) {
        return userRepository.findByEmail(userDto.getEmail());
    }

    private boolean emailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }

    private void updateUsername(String email, Long id) {

        if (emailExists(email)) {
            return;
        }
        userRepository.updateUsername(email, id);
    }

    private void updatePassword(String password, User user) {

        String passwordEncoded = passwordEncoder.encode(password);

        userRepository.updatePassword(passwordEncoded, user.getId());

    }
}
