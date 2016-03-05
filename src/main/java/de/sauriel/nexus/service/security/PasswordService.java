package de.sauriel.nexus.service.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

	public boolean matches(String password, String hash) {
		return passwordEncoder.matches(password, hash);
	}

}
