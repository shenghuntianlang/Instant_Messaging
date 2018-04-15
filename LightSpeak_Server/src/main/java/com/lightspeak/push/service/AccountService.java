package com.lightspeak.push.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * 逻辑处理类
 */
//http://localhost:8080/api/account/...
@Path("/account")
public class AccountService {
    //Get:http://localhost:8080/api/account/login
    @GET
    @Path("/login")
    public String get() {
        return "the login page is built successfully";
    }


}
