package com.nazmul.git.login;

/**
 * Singleton pattern for logging into GitHub
 * Intents:
 * a) Ensure a class has only one instance, and provide a global point of access to it.
 * b) Encapsulated "just-in-time initialization" or "initialization on first use".
 * <p>
 * Q. What if the application is multi-threaded?
 * a) Using injection framework from Spring
 * b) Using @Singleton annotation http://docs.oracle.com/javaee/6/tutorial/doc/gipvi.html
 * <p>
 * Q. Can I use dependency injection to solve the problem?
 * <p>
 * <p>
 * Q. Is Singleton overkill for the login purpose?
 */
