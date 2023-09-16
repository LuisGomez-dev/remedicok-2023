package com.remedicok.backend.service.security;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.remedicok.backend.dto.security.LoginRequest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthService {

    public void getJWTToken(Map<String, Object> objResult, String username) {
		String secretKey = "1234567890123456789012345678901234567890123456789012345678901234567890";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("ExpertChoiceJWTSecureZone")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();
        
        objResult.put("token", "Bearer " + token);

	}

	private String KeyGen() {
		final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=[]{};:,.<>?";
		final int LENGTH = 64;

        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[LENGTH];
        random.nextBytes(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public boolean esValido(LoginRequest localUser) {
        return true;
    }	
}




