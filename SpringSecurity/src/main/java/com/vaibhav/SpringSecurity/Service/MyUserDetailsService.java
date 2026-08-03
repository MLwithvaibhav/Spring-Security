package com.vaibhav.SpringSecurity.Service;

import com.vaibhav.SpringSecurity.Model.UserPrincipal;
import com.vaibhav.SpringSecurity.Model.Users;
import com.vaibhav.SpringSecurity.Repo.UserRepo;
import jakarta.persistence.Access;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Username received: " + username);
        Users user = repo.findByUsername(username);

        if(user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new UserPrincipal(user);
    }

}
