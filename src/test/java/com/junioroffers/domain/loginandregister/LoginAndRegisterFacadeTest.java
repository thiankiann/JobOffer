package com.junioroffers.domain.loginandregister;

import com.junioroffers.domain.loginandregister.dto.RegisterUserDto;
import com.junioroffers.domain.loginandregister.dto.RegistrationResultDto;
import com.junioroffers.domain.loginandregister.dto.UserDto;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;

class LoginAndRegisterFacadeTest {

    LoginAndRegisterFacade loginFacade = new LoginAndRegisterFacade(
            new LoginRepositoryTestImpl()
    );

    @Test
    public void should_throw_exception_when_user_not_found(){
        //given
        String username = "Mariusz K";
        //when
        Throwable thrown = catchThrowable(() ->loginFacade.findByUsername(username));
        //then
        assertThat(thrown).hasMessage("User not found");
        assertThat(thrown)
                .isInstanceOf(BadCredentialsException.class)
                .hasMessage("User not found");
    }
    @Test
    public void should_find_user_by_user_name(){
// given
        RegisterUserDto registerUserDto = new RegisterUserDto("Mariusz", "password");
        RegistrationResultDto register = loginFacade.register(registerUserDto);

        // when
        UserDto userByName = loginFacade.findByUsername(register.username());

        // then
        assertThat(userByName).isEqualTo(new UserDto(register.id(), "password", "Mariusz"));

    }
    @Test
    public void should_register_user(){
        //given
        RegisterUserDto registerUserDto = new RegisterUserDto("Mariusz","password");
        RegistrationResultDto registrationResultDto = loginFacade.register(registerUserDto);
        //when
        boolean isUserRegistered= registrationResultDto.created();
        //then
        assertThat(isUserRegistered).isEqualTo(true);
        assertThat(registrationResultDto).isInstanceOf(new RegistrationResultDto(registrationResultDto.id(),true,"Mariusz").getClass()); // ?? nie dokonca jestem pewny czy to poprawnie zrobilem
        assertThat(registrationResultDto.username()).isEqualTo("Mariusz");
        assertThat(registrationResultDto).isNotInstanceOf(UsernameNotFoundException.class);

    }

}
