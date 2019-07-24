package com.viniciuskenji.springboottests.queryfields;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/queryfields")
public class QueryFieldsController {

  @GetMapping
  @CustomFields
  public ResponseEntity<Object> getFields(HttpServletRequest request) {
    System.out.println("Getting fields");
    System.out.println(request.getAttribute("fields"));
    return ResponseEntity.status(HttpStatus.OK).body(request.getAttribute("fields"));
  }

  @GetMapping
  @RequestMapping("/multiple-parameters")
  @CustomFields
  public ResponseEntity<Object> getFields(HttpServletRequest request,
      @RequestHeader("Authorization") String authorization) {

    System.out.println("Getting fields in a method with Header: " + authorization);
    System.out.println(request.getAttribute("fields"));
    return ResponseEntity.status(HttpStatus.OK)
        .body(request.getAttribute("fields") + " " + authorization);
  }
}
