package com.junioroffers.domain.loginandregister;

import com.junioroffers.domain.loginandregister.dto.RegisterUserDto;
import com.junioroffers.domain.loginandregister.dto.RegistrationResultDto;
import com.junioroffers.domain.loginandregister.dto.UserDto;

import java.util.Optional;

interface LoginRepository {
    Optional<User> findUserByName(String username);

    User save(User user);
}
