package com.mallow.demo.camel.debugger;

import com.mallow.demo.camel.RouteTest;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class CamelDebugger extends CamelTestSupport {
    @Override
    public boolean isUseDebugger() {
        // must enable debugger
        return true;
    }

    @Override
    protected CamelContext createCamelContext() throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://localhost:61616"));
        context.addRoutes(new RouteTest());
        return context;
    }

    @Override
    protected void debugBefore(Exchange exchange, Processor processor,
                               ProcessorDefinition<?> definition, String id, String shortName) {
        // this method is invoked before we are about to enter the given processor
        // from your Java editor you can just add a breakpoint in the code line below
//        log.info("Before " + definition + " with body " + exchange.getIn().getBody());
        log.info(exchange.getIn().getBody().toString());
    }

    @Test
    public void test() throws InterruptedException {
        System.out.println(123);
        TimeUnit.HOURS.sleep(1);
    }
}
