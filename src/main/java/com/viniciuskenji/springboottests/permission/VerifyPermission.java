package com.viniciuskenji.springboottests.permission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // can use in method only.
public @interface VerifyPermission {

  String[] value();
  // public String permission() default "null";
}
