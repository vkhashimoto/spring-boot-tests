package com.viniciuskenji.springboottests.permission;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/recurso-protegido")
public class PermissionController {

  @PostMapping
  @VerifyPermission(value = {"acessaRecursoProtegido"})
  public ResponseEntity<Object> postToProtectedResource(HttpServletRequest request,
      @RequestHeader("Authorization") String authorization) {

    return ResponseEntity.status(HttpStatus.OK).body("Sucesso no recurso protegido");
  }


}
