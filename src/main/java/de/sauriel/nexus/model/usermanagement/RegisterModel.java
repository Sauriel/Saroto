package de.sauriel.nexus.model.usermanagement;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import de.sauriel.nexus.annotation.validation.FieldMatch;

@FieldMatch(first = "password", second = "passwordVerify", message = "{error.register.passwordsNotEqual}")
public class RegisterModel {

	private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	/*
	 * ^ # start-of-string (?=.*[0-9]) # a digit must occur at least once
	 * (?=.*[a-z]) # a lower case letter must occur at least once (?=.*[A-Z]) #
	 * an upper case letter must occur at least once (?=.*[@#$%^&+=]) # a
	 * special character must occur at least once (?=\S+$) # no whitespace
	 * allowed in the entire string .{8,} # anything, at least eight places
	 * though $ # end-of-string
	 */

	@Email(message = "{error.register.emailNotValid}")
	@NotBlank(message = "{error.register.emailisBlank}")
	@Length(min = 5, max = 30, message = "{error.register.emailNotLongEnough}")
	private String email;

	@NotBlank(message = "{error.register.passwordIsBlank}")
	@Length(min = 8, max = 30, message = "{error.register.passwordNotLongEnough}")
	@Pattern(regexp = PASSWORD_REGEX, message = "{error.register.passwordPatternDoesntMatch}")
	private String password;

	@NotBlank(message = "{error.register.passwordIsBlank}")
	@Length(min = 8, max = 30, message = "{error.register.passwordNotLongEnough}")
	@Pattern(regexp = PASSWORD_REGEX, message = "{error.register.passwordPatternDoesntMatch}")
	private String passwordVerify;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordVerify() {
		return passwordVerify;
	}

	public void setPasswordVerify(String passwordVerify) {
		this.passwordVerify = passwordVerify;
	}

	public String toDebugString() {
		if (password != null && password.equals(passwordVerify)) {
			return email + " / " + password;
		}
		return "Passwords for " + email + " are not equal: " + password + " and " + passwordVerify;
	}
}
