package solutions.smoothstone.entities;

import solutions.smoothstone.entities.UserAccessRecord;

import java.util.List;

public class Payload {
    public Payload() {}
    public String getApplicationInstance() {
        return applicationInstance;
    }

    public void setApplicationInstance(String applicationInstance) {
        this.applicationInstance = applicationInstance;
    }

    public List<UserAccessRecord> getData() {
        return data;
    }

    public void setData(List<UserAccessRecord> data) {
        this.data = data;
    }

    String applicationInstance;
    List<UserAccessRecord> data;
}