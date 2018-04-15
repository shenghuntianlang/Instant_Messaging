package com.lightspeak.push;

import com.lightspeak.push.service.AccountService;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.logging.Logger;

/**
 * 程序入口
 * 由于使用了jersey框架,所以应该继承ResourceConfig
 */
public class Application extends ResourceConfig {
    public Application() {
        //注册逻辑处理的包名
        /*packages("con.lightspeak.push.service")      两行代码性质相同,但是
          第二种用法可以在包名有改动的时候动态修改
         */
        packages(AccountService.class.getPackage().getName());

        //注册json解析器
        register(JacksonJsonProvider.class);

        //注册log打印输出
        register(Logger.class);
    }
}
