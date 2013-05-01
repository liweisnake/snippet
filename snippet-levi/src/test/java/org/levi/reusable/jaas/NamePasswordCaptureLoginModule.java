package org.levi.reusable.jaas;

import java.security.Principal;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextInputCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class NamePasswordCaptureLoginModule implements LoginModule {

	private CallbackHandler handler;

	private Subject subject;

	private String name;

	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> sharedState, Map<String, ?> options) {
		this.handler = callbackHandler;
		this.subject = subject;
	}

	public boolean login() throws LoginException {
		NameCallback nc = new NameCallback("name");
		PasswordCallback pc = new PasswordCallback("password", true);
		TextInputCallback tc = new TextInputCallback("capture", "1234");
		try {
			handler.handle(new Callback[] { nc, pc, tc });
		} catch (Exception e) {
			throw new LoginException("handler error.");
		}
		if (nc.getName().equals("levi")
				&& String.valueOf(pc.getPassword()).equals("123")
				&& tc.getText().equals("1234")) {
			name = nc.getName();
			return true;
		}
		return false;
	}

	public boolean commit() throws LoginException {
		if (name != null) {
			subject.getPrincipals().add(new Principal() {

				public String getName() {
					return name;
				}
			});
			return true;
		}
		return false;
	}

	public boolean abort() throws LoginException {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

}