package com.viniciuskenji.springboottests.permission;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Aspect
@Configuration
public class VerifyPermissionAspect {

  @Before(value = "@annotation(verifyPermission) && args(request,..)")
  public void verifyPermission(HttpServletRequest request, VerifyPermission verifyPermission)
      throws IOException {
    System.out.println("Permissions: " + verifyPermission.value().length);
    String permissions = "";
    for (String permission : verifyPermission.value()) {
      permissions += permission + ",";
    }

    permissions = permissions.substring(0, permissions.length() - 1);
    System.out.println("Permissions String: " + permissions);

    OkHttpClient client = new OkHttpClient();

    Request permRequest = new Request.Builder().url("https://httpbin.org/get?perm=" + permissions)
        .addHeader("Authorization", request.getHeader("Authorization")).build();
    // System.out.println(request.getHeader("Authorization"));
    // System.out.println(verifyPermission.value()[0]);
    Response response = client.newCall(permRequest).execute();
    String body = response.body().string();
    System.out.println(body);

    if (body.contains("auth-erro"))
      throw new RuntimeException("Invalid token");
  }


}
