package com.crio.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crio.springsecuritydemo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String customer) throws UsernameNotFoundException {
        return customerRepository.findByEmail(customer);
    }
}
