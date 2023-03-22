package sk.exxeta.nightofchances.refactored.example2.api;

import java.util.Objects;
import java.util.UUID;

public final class UserProfileDTO {
    private final UUID id;
    private final String username;
    private final String email;
    private final String phone;
    private final String addressLine1;
    private final String addressLine2;
    private final String addressLine3;

    public UserProfileDTO(UUID id, String username, String email) {
        this(id, username, email, "", "", "", "");
    }

    public UserProfileDTO(UUID id,
                          String username, String email, String phone,
                          String addressLine1, String addressLine2, String addressLine3) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
    }

    public UUID id() {
        return id;
    }

    public String username() {
        return username;
    }

    public String email() {
        return email;
    }

    public String phone() {
        return phone;
    }

    public String addressLine1() {
        return addressLine1;
    }

    public String addressLine2() {
        return addressLine2;
    }

    public String addressLine3() {
        return addressLine3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UserProfileDTO) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.username, that.username) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.phone, that.phone) &&
                Objects.equals(this.addressLine1, that.addressLine1) &&
                Objects.equals(this.addressLine2, that.addressLine2) &&
                Objects.equals(this.addressLine3, that.addressLine3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, phone, addressLine1, addressLine2, addressLine3);
    }

    @Override
    public String toString() {
        return "UserProfileDTO[" +
                "id=" + id + ", " +
                "username=" + username + ", " +
                "email=" + email + ", " +
                "phone=" + phone + ", " +
                "addressLine1=" + addressLine1 + ", " +
                "addressLine2=" + addressLine2 + ", " +
                "addressLine3=" + addressLine3 + ']';
    }


}
