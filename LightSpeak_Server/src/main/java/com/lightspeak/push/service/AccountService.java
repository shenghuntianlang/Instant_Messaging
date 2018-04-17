package com.lightspeak.push.service;

import com.lightspeak.push.bean.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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

    @POST
    @Path("/login")
    //指定返回格式为json
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User post() {
        User user = new User();
        user.setName("刘永俊");
        user.setGender(0);
        return user;
    }

}
