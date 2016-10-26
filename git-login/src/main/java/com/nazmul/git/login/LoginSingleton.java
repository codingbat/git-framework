package com.nazmul.git.login;

import org.eclipse.egit.github.core.client.GitHubClient;

import java.io.Serializable;

/**
 * By  making the Singleton class as a final class, it allows the compiler to apply performance
 * optimizations and prevents from subclassing.
 */
public final class LoginSingleton extends GitHubClient implements Serializable {

  private static final long serialVersionUID = 3949052050645678406L;

  private static LoginSingleton loginInstance = null;

  private boolean signedIn;

  /**
   * This constructor defeat instantiation.
   */
  private LoginSingleton() {

    signedIn = false;
  }

  /**
   * Using Lazy instantiation technique, this Singleton class is only created when getInstance
   * method is called the first time. This technique ensures that singleton instances are created
   * only when needed.
   *
   * @return Singleton object
   */
  public static synchronized LoginSingleton getInstance() {

    if (loginInstance == null) {
      System.out.println("Creating unique instance of GitHub Login");
      loginInstance = new LoginSingleton();
    }
    System.out.println("Returning instance of GitHub Login");
    return loginInstance;
  }

  public void signIn(String login, String pass) {
    setCredentials(login, pass);
    if(getUser().equals(login)) {
      signedIn = true;
      System.out.println("You  have successfully signed in!");
    }
  }

  public void signIn(String token) {
    signedIn = true;
    System.out.println("You  have successfully signed in!");
  }

  public void signOut(int id) {
    if(isSignedIn()) {
      signedIn = false;
      System.out.println("You have successfully signed out!");
    }
  }

  public boolean isSignedIn() {

    return signedIn;
  }
}
