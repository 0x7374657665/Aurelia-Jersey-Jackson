package solutions.smoothstone;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class BackendConfig extends ResourceConfig {

    public BackendConfig() {
        packages("solutions.smoothstone");
    }

}
