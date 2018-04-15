package com.lightspeak.push.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * 逻辑处理类
 */

@Path("/account")
public class AccountService {
    @GET
    @Path("login")
    private String get(){
        return "the login page is built successfully";
    }
}
