package solutions.smoothstone;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class BackendConfig extends ResourceConfig {

    public BackendConfig() {
        register(JacksonFeature.class);
        packages("solutions.smoothstone");
    }

}
