package com.nazmul.git.login;

import org.eclipse.egit.github.core.User;

public abstract class Login extends User {

  public abstract void login();

  public abstract void logout();

  public abstract boolean rememberMe();

}
