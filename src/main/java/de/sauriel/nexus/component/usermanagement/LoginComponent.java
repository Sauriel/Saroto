package de.sauriel.nexus.component.usermanagement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.sauriel.nexus.model.usermanagement.LoginModel;
import de.sauriel.nexus.service.security.PasswordService;

@Component
public class LoginComponent {

	@Autowired
	private PasswordService passwordService;

	@Autowired
	private UserDaoComponent userDao;

	public boolean login(LoginModel model) {
		Optional<String> userHashFromDB = userDao.getUserHash(model.getLoginName());
		if (userHashFromDB.isPresent()) {
			return passwordService.matches(model.getPassword(), userHashFromDB.get());
		}
		return false;
	}

}
