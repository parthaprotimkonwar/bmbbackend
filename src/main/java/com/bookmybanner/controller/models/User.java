package com.bookmybanner.controller.models;

import com.bookmybanner.models.document.Users;
import com.google.common.base.Objects;

/**
 * Created by parthaprotimkonwar on 08/04/17.
 */
public class User {

    private String userName;
    private String email;
    private String password;
    private String phoneNo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }


    public Users toUsers() {
        Users users = new Users();
        users.setEmail(this.getEmail());
        users.setPassword(this.getPassword());
        users.setPhoneNo(this.getPhoneNo());
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getEmail());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", phoneNo='").append(phoneNo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
