package org.fabric3.samples.springboot;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fabric3.api.annotation.model.EndpointUri;
import org.springframework.stereotype.Component;

/**
 * Service exposed as a REST endpoint using Fabric3.
 */
@EndpointUri("ui")
@Path("messages")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Component
public class RestService {

    @GET
    @Path("hello")
    public String hello() {
        return "hello";
    }

}
