package de.sauriel.nexus.component.usermanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.sauriel.nexus.model.usermanagement.RegisterModel;
import de.sauriel.nexus.service.security.PasswordService;

@Component
public class RegisterComponent {

	@Autowired
	private PasswordService passwordService;

	@Autowired
	private UserDaoComponent userDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterComponent.class);

	public boolean registerUser(RegisterModel registerModel) {
		LOGGER.debug("Registering user \"{}\".", registerModel.getEmail());
		String encodedPassword = passwordService.encodePassword(registerModel.getPassword());
		return userDao.create(registerModel.getEmail(), encodedPassword);
	}
}
