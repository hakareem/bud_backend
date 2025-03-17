package com.hakareem.Review.service;

import com.hakareem.Review.domain.User;
import com.hakareem.Review.repository.UserRepository;
import com.hakareem.Review.util.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CustomPasswordEncoder customPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepo.findByUsername(username);
        return userOpt.orElseThrow(() -> new UsernameNotFoundException("Invalid Credentials"));
    }

    public boolean existsByUsername(String username) {
        return userRepo.existsByUsername(username);
    }

    public void save(User newUser) {
        newUser.setPassword(customPasswordEncoder.getPasswordEncoder().encode(newUser.getPassword()));
        userRepo.save(newUser);
    }
}
