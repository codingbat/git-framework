package com.nazmul.git.login;

import java.util.Scanner;

/**
 * Sample application to login to GitHub.
 */
public class Test {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("GitHub username: ");
        String user = in.nextLine();

        System.out.println("GitHub password: ");
        String password = in.nextLine();

        if ( user.equals("admin") && password.equals("admin")) {
            System.out.println("Congratulations, you have logged into GitHub.");
        }


    }
}
