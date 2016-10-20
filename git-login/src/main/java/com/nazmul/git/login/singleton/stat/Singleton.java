package com.nazmul.git.login.singleton.stat;

public class Singleton {

  private static Singleton uniqueInstance = new Singleton();

  private Singleton() {

  }

  public static Singleton getInstance() {

    return uniqueInstance;
  }
}
