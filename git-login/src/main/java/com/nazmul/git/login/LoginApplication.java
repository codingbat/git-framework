package com.nazmul.git.login;

import java.util.Scanner;

/**
 * Sample application to signIn to GitHub.
 */
public class LoginApplication {

    public static void main(String[] args) {

        LoginSingleton login = LoginSingleton.getInstance();

        Scanner in = new Scanner(System.in);
        System.out.println("GitHub username: ");
        String user = in.nextLine();

        System.out.println("GitHub password: ");
        String password = in.nextLine();

        login.signIn(user, password);

    }
}
