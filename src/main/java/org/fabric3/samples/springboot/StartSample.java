package org.fabric3.samples.springboot;

import java.util.Arrays;

import org.fabric3.api.node.Bootstrap;
import org.fabric3.api.node.Domain;
import org.fabric3.api.node.Fabric;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 *
 */
@SpringBootApplication
public class StartSample {

    public static void main(String... args) throws Exception {
        System.setProperty("server.port", "8190");
        ApplicationContext ctx = SpringApplication.run(StartSample.class, args);

        Fabric fabric = Bootstrap.initialize();
        fabric.addProfile("rs");
        fabric.start();

        Domain domain = fabric.getDomain();
        domain.deploy("Foo", new FooServiceImpl());

        FooService service = domain.getService(FooService.class);

        System.out.println(service.hello());

        fabric.stop();

    }
}
