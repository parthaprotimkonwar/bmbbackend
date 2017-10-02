package com.bookmybanner.models;

import com.bookmybanner.models.constraints.Mergeable;
import com.google.common.base.Objects;

import java.math.BigInteger;

/**
 * Created by parthaprotimkonwar on 04/04/17.
 */
public class UserInfo implements Mergeable<UserInfo> {

    private BigInteger userId;
    private String userName;
    private String phoneNo;
    private String email;

    public UserInfo() {
    }

    public UserInfo(BigInteger userId, String userName, String phoneNo, String email) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNo = phoneNo;
        this.email = email;
    }


    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public UserInfo merge(UserInfo otherUserInfo) {

        if (null == otherUserInfo) return this;

        if (null != otherUserInfo.getUserName()) setUserName(otherUserInfo.getUserName());
        if (null != otherUserInfo.getPhoneNo()) setPhoneNo(otherUserInfo.getPhoneNo());
        if (null != otherUserInfo.getEmail()) setEmail(otherUserInfo.getEmail());

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equal(getUserId(), userInfo.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getUserId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserInfo{");
        sb.append("userId=").append(userId);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", phoneNo='").append(phoneNo).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
