package com.example.ReadingIsGood.Services;

import com.example.ReadingIsGood.Models.LoginUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import static java.util.Collections.emptyList;
import com.example.ReadingIsGood.Repositories.LoginUserRepository;

@Service
public class LoginUserService implements UserDetailsService {

    private LoginUserRepository loginUserRepository;

    public LoginUserService(LoginUserRepository loginUserRepository) {
        this.loginUserRepository = loginUserRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser loginUser = loginUserRepository.findByUsername(username);
        if (loginUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(loginUser.getUsername(), loginUser.getPassword(), emptyList());
    }
}
