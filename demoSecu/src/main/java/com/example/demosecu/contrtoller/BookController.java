package com.example.demosecu.contrtoller;


import com.example.demosecu.config.JwtTokenGiver;
import com.example.demosecu.entity.BookUserDetail;
import com.example.demosecu.model.LoginRequest;
import com.example.demosecu.model.LoginResponse;
import com.example.demosecu.service.IUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
//    @Autowired
//    private IBookRepository bookRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenGiver jwtTokenGiver;

    @Autowired
    private IUserDetailService iUserDetailService;

//    @GetMapping("/books")
//    List<Book> findAll(){
//        return bookRepository.findAll();
//    }
    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenGiver.generateToken((BookUserDetail) iUserDetailService.loadUserByUsername(loginRequest.getUserName()));

        return new LoginResponse(jwt);
    }


}
