package com.maven.springboot.shop.controllers;

import com.maven.springboot.shop.configurations.TokenProvider;
import com.maven.springboot.shop.entities.AuthToken;
import com.maven.springboot.shop.entities.User;
import com.maven.springboot.shop.repositories.RoleRepository;
import com.maven.springboot.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        if (userRepository.findByEmail(user.getEmail()) == null) {

            User user1 = new User();
            user1.setEmail(user.getEmail());
            user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user1.setRoles(new HashSet<>(roleRepository.findAll()));
            userRepository.save(user1);

            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(),
                            user.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            final String token = jwtTokenUtil.generateToken(authentication);

            return ResponseEntity.ok(new AuthToken(token));
        } else {
            return login(user);
        }
    }
}