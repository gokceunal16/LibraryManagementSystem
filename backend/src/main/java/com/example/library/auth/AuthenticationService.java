package com.example.library.auth;

import com.example.library.config.JwtService;
import com.example.library.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.library.entity.User;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) throws SQLException {
        User user = new User(
                0,
                null,
                null,
                null,
                request.getFirst_name(),
                request.getLast_name(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getPhone(),
                request.getCity(),
                request.getStreet(),
                request.getPostal_code(),
                request.getRole_id());

            repository.createUser(user);


        User createdUser = repository.findByEmail(request.getEmail());

        Claims claims = Jwts.claims();
        claims.put("user_id", createdUser.getId());
        String jwtToken = jwtService.generateToken(claims, user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user_id(createdUser.getId())
                .role_id(createdUser.getRole_id())
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = repository.findByEmail(request.getEmail());
        Claims claims = Jwts.claims();
        claims.put("user_id", user.getId());

        String jwtToken = jwtService.generateToken(claims, user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user_id(user.getId())
                .role_id(user.getRole_id())
                .build();
    }
}
