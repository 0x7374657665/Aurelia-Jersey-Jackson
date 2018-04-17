package solutions.smoothstone.api;

import solutions.smoothstone.entities.Payload;
import solutions.smoothstone.entities.UserAccessRecord;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.util.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("recon-data")
public class ReconDataResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("json")
    public Response acceptJsonData(Payload payload) {

        String applicationInstance = payload.getApplicationInstance();
        List<UserAccessRecord> data = payload.getData();

        List<String> response = new ArrayList<>();

        final int[] recordCount = {0};
        response.add(applicationInstance);
        data.forEach(rec -> {
            System.out.println(rec.getAccount() == null ? "user and account match: " + rec.getUsername() : String.format("user: %s\tacct: %s", rec.getUsername(), rec.getAccount()));
            String acct = rec.getAccount() == null ? rec.getUsername() : rec.getAccount();
            rec.getEntitlements().forEach(ent -> {
                response.add(String.join("|",Arrays.asList(new String[]{
                        acct,
                        ent,
                        rec.isActive() ? "A" : "I",
                        rec.getUsername()
                })));
                recordCount[0] += 1;
            });

        });

        System.out.println("*** Processed " + recordCount[0] + " records");

        return Response.ok(response).build();

    }


}
