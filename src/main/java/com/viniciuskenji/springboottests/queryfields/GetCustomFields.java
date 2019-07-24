package com.viniciuskenji.springboottests.queryfields;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GetCustomFields {
  public List<String> getCustomFields(String path) {
    if (path != null && path.contains(",")) {
      return Arrays.asList(path.split(","));
    }
    return Arrays.asList("*");
  }
}
