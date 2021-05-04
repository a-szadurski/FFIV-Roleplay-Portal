package com.ffivrpportal.dto;

import com.ffivrpportal.model.User;
import com.ffivrpportal.validation.PasswordMatches;
import com.ffivrpportal.validation.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private Long id;

    @ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    private String email;

    @NotNull(message = "{NotEmpty.user.password}")
    @Size(min = 8, max = 25)
    private String password;

    @NotNull(message = "{NotEmpty.user.matchingPassword}")
    @Size(min = 8, max = 25)
    private String matchingPassword;

    private boolean enabled;

    public UserDto(Long id, String email, Boolean enabled) {
        this.id = id;
        this.email = email;
        this.enabled = enabled;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

}
