package com.nazmul.git.login;

import org.apache.http.HttpResponse;
import org.eclipse.egit.github.core.client.GitHubClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

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

  public static void login(String login, String password) throws ClientProtocolException, IOException {
    HttpClient client = new DefaultHttpClient();
    HttpGet request = new HttpGet("https://api.github.com");
    HttpResponse response = client.execute(request);
    BufferedReader rd = new BufferedReader (
            new InputStreamReader(response.getEntity().getContent()));
    String line = "";
    while ((line = rd.readLine()) != null) {
      System.out.println(line);
    }
  }
}
