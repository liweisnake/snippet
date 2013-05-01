package org.levi.reusable.jaas;

import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextInputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.springframework.core.io.ClassPathResource;

public class LoginClient {

	public boolean login(LoginEntity le) {
		try {
			NamePasswordCaptureCallbackHandler callback = new NamePasswordCaptureCallbackHandler(
					le);
			LoginContext context = new LoginContext("loginModule", callback);
			context.login();
			return true;
		} catch (LoginException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		ClassPathResource cpr = new ClassPathResource("loginModule.jaas");
		System.setProperty("java.security.auth.login.config", cpr.getFile().getAbsolutePath());
		System.out.println("Please input login name:");
		Scanner scanner = new Scanner(System.in);
		String userName = scanner.next();
		System.out.println("Please input password:");
		String password = scanner.next();
		scanner.close();
		LoginEntity le = new LoginEntity(userName, password, "1234");
		LoginClient client = new LoginClient();
		System.out.println(client.login(le));
	}

	private static class NamePasswordCaptureCallbackHandler implements
			CallbackHandler {

		private LoginEntity le;

		public NamePasswordCaptureCallbackHandler(LoginEntity le) {
			this.le = le;
		}

		public void handle(Callback[] callbacks) throws IOException,
				UnsupportedCallbackException {
			for (int i = 0; i < callbacks.length; i++) {
				if (callbacks[i] instanceof NameCallback) {
					NameCallback nc = (NameCallback) callbacks[i];
					nc.setName(le.getUserName());
				} else if (callbacks[i] instanceof PasswordCallback) {
					PasswordCallback pc = (PasswordCallback) callbacks[i];
					pc.setPassword(le.getPassword().toCharArray());
				} else if (callbacks[i] instanceof TextInputCallback) {
					TextInputCallback tic = (TextInputCallback) callbacks[i];
					tic.setText(le.getCapture());
				}
			}
		}
	}
}

