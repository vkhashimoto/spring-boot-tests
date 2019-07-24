package com.viniciuskenji.springboottests.queryfields;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CustomFieldsAspect {

  @Autowired
  GetCustomFields getCustomFields;

  @Before("@annotation(com.viniciuskenji.springboottests.queryfields.CustomFields) && args(request,..)")
  public void before(HttpServletRequest request) {
    if (!(request instanceof HttpServletRequest))
      throw new RuntimeException("'request' should be HttpServletRequest type");

    String fieldsParameters = request.getParameter("fields");
    List<String> fields = getCustomFields.getCustomFields(fieldsParameters);

    request.setAttribute("fields", fields);
  }


}
