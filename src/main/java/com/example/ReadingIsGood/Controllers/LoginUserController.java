package com.example.ReadingIsGood.Controllers;

import com.example.ReadingIsGood.Models.LoginUser;
import com.example.ReadingIsGood.Validation.LoginUserValidation;
import javax.ws.rs.core.Response;
import com.example.ReadingIsGood.Validation.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.ReadingIsGood.Repositories.LoginUserRepository;

@RestController
@RequestMapping("/loginUser")
public class LoginUserController {

    @Autowired
    private LoginUserRepository loginUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginUserController(LoginUserRepository loginUserRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.loginUserRepository = loginUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public Response signUp(@RequestBody LoginUser loginUser) {
        LoginUserValidation validation = new LoginUserValidation();
        validation.validate(loginUser);
        if (validation.failed()) {
            return Response.status(400).entity(new Error(validation.errors().all()).toJson()).build();
        } else {
            loginUser.setPassword(bCryptPasswordEncoder.encode(loginUser.getPassword()));
           loginUserRepository.save(loginUser);
            return Response.ok().build();
        }
    }

}
