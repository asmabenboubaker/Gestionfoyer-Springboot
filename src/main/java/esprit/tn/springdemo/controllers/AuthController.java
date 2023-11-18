package esprit.tn.springdemo.controllers;

import esprit.tn.springdemo.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        // Replace this with actual user authentication logic.
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            // Generate a JWT token if the username and password are correct.
            //String token = issueToken(user.getUsername());
            String token = generateToken(user.getUsername(), 100000);
            return token;
        } else {
            return "Authentication failed"; // Handle authentication failure
        }
    }

    public String generateToken(String subject, long expirationTimeInMilliseconds) {
        // Create a secret key from the provided secret key string
        String keyString = "simplekey";
        Key key = new SecretKeySpec(Base64.getEncoder().encode(keyString.getBytes()), 0, keyString.getBytes().length, "DES");

        // Build the JWT
        return Jwts.builder()
                .setSubject(subject) // The subject of the token
                .setIssuedAt(new Date()) // Token issuance time
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeInMilliseconds)) // Token expiration time
                .signWith(SignatureAlgorithm.HS256, key) // Signing algorithm and key
                .compact(); // Compact the JWT to a string
    }
}
