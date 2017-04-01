package com.mallow.demo.camel;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by lcy on 2016/6/27.
 */
public class RouteTest extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("activemq:queue:cameltest").to("activemq:queue:cameltest2");

    }

}
