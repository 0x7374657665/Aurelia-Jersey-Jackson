package solutions.smoothstone;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class BackendConfig extends ResourceConfig {

    public BackendConfig() {
        register(MultiPartFeature.class);
        packages("solutions.smoothstone");
    }

}
