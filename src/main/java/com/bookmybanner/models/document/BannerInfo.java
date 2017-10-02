package com.bookmybanner.models.document;

import com.bookmybanner.models.constraints.Mergeable;
import com.bookmybanner.models.BannerAttributes;
import com.bookmybanner.models.STATUS;
import com.bookmybanner.models.UserInfo;
import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by parthaprotimkonwar on 03/04/17.
 */
@Document(collection = "BANNER_INFO")
public class BannerInfo implements Serializable, Mergeable<BannerInfo>{

    @Id
    private BigInteger bannerId;

    private BannerAttributes bannerAttributes;

    private Double price;

    @GeoSpatialIndexed(name = "coordinates")
    private Point coordinates;

    private STATUS status;

    private UserInfo userInfo;

    public BannerInfo() {
    }

    public BannerInfo(BannerAttributes bannerAttributes, Double price, Point coordinates, STATUS status, UserInfo userInfo) {
        this.bannerAttributes = bannerAttributes;
        this.price = price;
        this.coordinates = coordinates;
        this.status = status;
        this.userInfo = userInfo;
    }

    public BigInteger getBannerId() {
        return bannerId;
    }

    public void setBannerId(BigInteger bannerId) {
        this.bannerId = bannerId;
    }

    public BannerAttributes getBannerAttributes() {
        return bannerAttributes;
    }

    public void setBannerAttributes(BannerAttributes bannerAttributes) {
        this.bannerAttributes = bannerAttributes;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


    @Override
    public BannerInfo merge(BannerInfo otherBanner) {
        if(otherBanner == null) return this;

        if(otherBanner.getPrice() != null) setPrice(otherBanner.getPrice());
        if(null != otherBanner.coordinates) setCoordinates(otherBanner.getCoordinates());
        if(null != otherBanner.status) setStatus(otherBanner.getStatus());

        bannerAttributes.merge(otherBanner.bannerAttributes);
        userInfo.merge(otherBanner.getUserInfo());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BannerInfo that = (BannerInfo) o;
        return Objects.equal(getBannerId(), that.getBannerId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getBannerId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BannerInfo{");
        sb.append("bannerId=").append(bannerId);
        sb.append(", bannerAttributes=").append(bannerAttributes);
        sb.append(", price=").append(price);
        sb.append(", coordinates=").append(coordinates);
        sb.append(", status=").append(status);
        sb.append(", userInfo=").append(userInfo);
        sb.append('}');
        return sb.toString();
    }
}
