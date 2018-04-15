package solutions.smoothstone;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("string")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        Message msg = new Message("Hello, Jackson!", 117);
        return Response.ok(msg).build();
    }

    private class Message {
        public Message(String message, int luckyNum) {
            this.message = message;
            this.luckyNum = luckyNum;
        }

        public String getMessage() {
            return message;
        }

        public int getLuckyNum() {
            return luckyNum;
        }

        final String message;
        final int luckyNum;
    }
}
