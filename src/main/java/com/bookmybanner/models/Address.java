package com.bookmybanner.models;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;

/**
 * Created by parthaprotimkonwar on 04/04/17.
 */
public class Address {

    @Id
    private BigInteger addressId;
    private String address;
    private String addressType;
    private String pinCode;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equal(addressId, address.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(addressId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("addressId=").append(addressId);
        sb.append(", address='").append(address).append('\'');
        sb.append(", addressType='").append(addressType).append('\'');
        sb.append(", pinCode='").append(pinCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
