package com.example.demosecu.service;

import com.example.demosecu.entity.BookUserDetail;
import com.example.demosecu.entity.User;
import com.example.demosecu.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class IUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByName(s);
        if(user == null){
            throw new UsernameNotFoundException(s);
        }
        return new BookUserDetail(user);
    }

}
