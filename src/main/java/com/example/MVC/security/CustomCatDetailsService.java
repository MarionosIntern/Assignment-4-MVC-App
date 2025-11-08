package com.example.MVC.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.MVC.Cat.Cat;
import com.example.MVC.Cat.CatRepository;

@Service
public class CustomCatDetailsService implements UserDetailsService{
    @Autowired
    private CatRepository catRepository;
    private Object org;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Cat cat = catRepository.getCatsByName(username)
        .stream()
        .findFirst()
        .orElseThrow(() -> new UsernameNotFoundException("Cat not found with name: " + username));
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(
            cat.getName(),
            cat.getSex(),
            authorities
        );
    }
}