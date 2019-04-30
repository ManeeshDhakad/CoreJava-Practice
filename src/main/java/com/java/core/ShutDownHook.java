package com.java.core;

public class ShutDownHook
{
  public static void main(String[] args) {
 
    Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        System.out.println("Do some cleanup when JVM shutting down.");
      }
    });
    System.out.println("Application Terminating ...");
  }
}