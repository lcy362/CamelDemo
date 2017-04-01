package com.mallow.demo.camel;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import io.hawt.embedded.Main;
import java.util.concurrent.TimeUnit;

/**
 * Created by lcy on 2017/4/1.
 */
public class MainWithHawtio {
    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        try {
            context.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://localhost:61616"));
            context.addRoutes(new RouteTest());
            context.start();

            Main main = new Main();
            main.setWar("hawtio.war");

            main.run();

            TimeUnit.MINUTES.sleep(20);
        }finally {
            context.stop();
        }
    }
}
