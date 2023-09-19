package com.remedicok.backend.security;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.remedicok.backend.data.personal.Perfil;
import com.remedicok.backend.data.personal.Usuario;
import com.remedicok.backend.data.personal.UsuarioRepository;
import com.remedicok.backend.service.personal.UsuarioService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class AuthService {

	@Autowired
	UsuarioRepository usuarioRepository;

	private boolean credencialValida;

	public boolean isCredencialValida() {
		return credencialValida;
	}

	public void setCredencialValida(boolean credencialValida) {
		this.credencialValida = credencialValida;
	}

	private void generateToken(Map<String, Object> objResult, Usuario usuario) {
		String secretKey = "1234567890123456789012345678901234567890123456789012345678901234567890";
		Date now = new Date();
		Date expirationDate = new Date(now.getTime() + 3600000); // 1 hora de expiración

		Set<Perfil> perfilesUsuario = usuario.getPerfiles(); // Obtén los perfiles del usuario
		List<GrantedAuthority> grantedAuthorities = createAuthoritiesFromPerfiles(perfilesUsuario);
		
		String token = Jwts
				.builder()
				.setId("RemedicokJWTSecureZone")
				.setSubject(usuario.getCorreoElectronico())
				.claim("authorities",grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(now)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes())
				.compact();

		objResult.put("token", "Bearer " + token);
	}

	private List<GrantedAuthority> createAuthoritiesFromPerfiles(Set<Perfil> perfiles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for (Perfil perfil : perfiles) {
			String roleName = perfil.getNombre();
			authorities.add(new SimpleGrantedAuthority(roleName));
		}
		
		return authorities;
	}
	
	/*
	private String KeyGen() {
		final int LENGTH = 64;

		SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[LENGTH];
		random.nextBytes(bytes);
		return new String(bytes, StandardCharsets.UTF_8);
	}

	
	public boolean esValido1(LoginRequestDTO localUser) {
		return true;
	}
	*/

	public void procesaCredencial(Map<String, Object> objResult, LoginRequestDTO localUser) {
		Usuario usuario = usuarioRepository.findByCorreoElectronicoAndContrasena(localUser.getUsuario(),
				localUser.getContrasena());
		if (usuario == null) {
			credencialValida = false;
			objResult.put("error", "Credencial no valida");
		} else {
			credencialValida = true;
			objResult.put("usuario", usuario);
			generateToken(objResult,usuario);
		}
	}
}
