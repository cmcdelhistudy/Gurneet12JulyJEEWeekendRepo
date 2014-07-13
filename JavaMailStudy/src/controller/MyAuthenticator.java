package controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {

	PasswordAuthentication pa;

	public MyAuthenticator(String userName, String password) {
		pa = new PasswordAuthentication(userName, password);
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}

}
