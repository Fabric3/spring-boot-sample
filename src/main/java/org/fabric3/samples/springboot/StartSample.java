package org.fabric3.samples.springboot;

import java.util.Collections;
import java.util.Map;

import org.fabric3.api.node.Bootstrap;
import org.fabric3.api.node.Fabric;
import org.fabric3.spring.boot.SpringApplicationConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 *
 */
@SpringBootApplication
public class StartSample {

    public static void main(String... args) {
        // sets the Spring boot servlet container port
        System.setProperty("server.port", "8193");

        SpringApplication application = new SpringApplication(StartSample.class);

        // bootstrap the Fabric3 runtime with the REST profile
        Fabric fabric = Bootstrap.initialize();
        fabric.addProfile("rs");

        // define the context path for HTTP/S endpoints
        String contextPath = System.getProperty("fabric3.context.path", "/fabric3");
        Map<String, Object> properties = Collections.<String, Object>singletonMap("http.context", contextPath);

        // initialize the Spring boot application with Fabric3
        SpringApplicationConfigurer.initialize(application, fabric, properties);

        // run the application
        ApplicationContext context = application.run(args);

        // publish the remote endpoints and start receiving requests
        SpringApplicationConfigurer.startFabric(context, fabric);
    }
}
