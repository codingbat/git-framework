package com.nazmul.git.login;

import com.jcabi.github.Gists;
import com.jcabi.github.Github;
import com.jcabi.github.RtGithub;
import org.eclipse.egit.github.core.service.UserService;

import java.io.Serializable;
import java.util.Random;

/**
 * By  making the Singleton class as a final class, it allows the compiler to apply performance optimizations and
 * prevents from subclassing.
 */
public final class LoginSingleton extends UserService implements Serializable {

    private static LoginSingleton loginInstance = null;
    private boolean signedIn;

    /**
     * This constructor defeat instantiation.
     */
    private LoginSingleton() {
        this.signedIn = false;
    }

    /**
     * Using Lazy instantiation technique, this Singleton class is only created
     * when getInstance method is called the first time. This technique ensures that singleton instances are created
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

    public static void signIn(String login, String pass) {
        Github github = new RtGithub(login, pass);
        Gists gists = github.gists();
        System.out.println("You  have successfully signed in!");
    }

    public static void signOut(int id) {
        System.out.println("You have successfully signed out!");
    }

    public boolean isSignedIn() {
        return signedIn;
    }

    private static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
