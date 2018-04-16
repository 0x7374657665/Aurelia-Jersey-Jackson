package solutions.smoothstone.api;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFlatFile(
            @FormDataParam("applicationInstance") String appInstance,
            @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file")FormDataContentDisposition fileMetaData
            ) throws IOException {

        Scanner scan = new Scanner(fileInputStream);

        int lineCount = 0;
        while(scan.hasNextLine()) {
            System.out.println(++lineCount + ": " + scan.nextLine());
        }

        scan.close();
        fileInputStream.close();

        Map<String, String> response = new HashMap<>();
        response.put("appInstance", appInstance);
        response.put("fileName",fileMetaData.getFileName());
        response.put("lineCount","" + lineCount);
        return Response.ok(response).build();
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
