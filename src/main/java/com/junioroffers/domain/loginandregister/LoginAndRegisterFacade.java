package com.junioroffers.domain.loginandregister;

import com.junioroffers.domain.loginandregister.dto.RegisterUserDto;
import com.junioroffers.domain.loginandregister.dto.RegistrationResultDto;
import com.junioroffers.domain.loginandregister.dto.UserDto;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class LoginAndRegisterFacade {

    private static final String USER_NOT_FOUND = "User not found";

    private final LoginRepository repository;

    public UserDto findByUserName(String username){
        return repository.findUserByName(username)
                .map(user -> new UserDto(user.id(),user.password(),user.username()))
                        .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND) );
    }
    public RegistrationResultDto register(RegisterUserDto registerUserDto) {
        final User user = User.builder()
                .username(registerUserDto.username())
                .password(registerUserDto.password())
                .build();
        User savedUser = repository.save(user);
        return new RegistrationResultDto(savedUser.id(), true, savedUser.username());
//    public RegistrationResultDto register(RegisterUserDto registerUserDto){
//        boolean isUserAlreadyExist = findByUserName(registerUserDto.username()) != null;
//        if( !isUserAlreadyExist){
//            return repository.saveUser(registerUserDto);
//
//        }
//        return new RegistrationResultDto(registerUserDto.id(),true,registerUserDto.username() );
//    }
    }
}
