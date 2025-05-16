package com.junioroffers.domain.loginandregister;

import com.junioroffers.domain.loginandregister.dto.RegisterUserDto;
import com.junioroffers.domain.loginandregister.dto.RegistrationResultDto;
import com.junioroffers.domain.loginandregister.dto.UserDto;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

class LoginRepositoryTestImpl implements LoginRepository {
    private final Map<String,User>  userList = new ConcurrentHashMap<>();
    @Override
    public Optional<User> findUserByName(String username) {
        return Optional.ofNullable(userList.get(username));
    }

    @Override
    public User save(User entity) {
        UUID id = UUID.randomUUID();
        User user = new User(
                id.toString(),
                entity.username(),
                entity.password()
        );
        userList.put(user.username(), user);
        return user;
    }
}
