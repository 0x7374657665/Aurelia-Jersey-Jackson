package solutions.smoothstone.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;


public class UserAccessRecord {

    private String username;

    @JsonInclude(NON_NULL)
    private String account;

    private List<String> entitlements;

    private boolean active;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<String> getEntitlements() {
        return entitlements;
    }

    public void setEntitlements(List<String> entitlements) {
        this.entitlements = entitlements;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserAccessRecord{" +
                "username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", entitlements=" + entitlements +
                ", active=" + active +
                '}';
    }
}
