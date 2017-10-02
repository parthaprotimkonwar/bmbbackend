package com.bookmybanner.controller.models;

import com.bookmybanner.models.BannerAttributes;
import com.bookmybanner.models.UserInfo;
import com.bookmybanner.models.document.BannerInfo;
import org.springframework.data.geo.Point;
import org.springframework.util.StringUtils;

import java.math.BigInteger;

/**
 * Created by parthaprotimkonwar on 08/04/17.
 */
public class Banner {

    private BigInteger id;
    private Double latitude;
    private Double longitude;
    private Double price;
    private String label;
    private Integer height;
    private Integer width;
    private String description;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BannerInfo toBannerInfo() {
        BannerInfo bannerInfo = new BannerInfo();
        bannerInfo.setBannerId(this.getId());

        //create a banner attributes object
        BannerAttributes bannerAttributes = new BannerAttributes();
        bannerAttributes.setWidth(this.getWidth());
        bannerAttributes.setDescription(this.getDescription());
        bannerAttributes.setHeight(this.getHeight());
        bannerAttributes.setLabel(this.getLabel());
        bannerInfo.setBannerAttributes(bannerAttributes);

        //initializing with a blank userInfo object
        bannerInfo.setUserInfo(new UserInfo());
        bannerInfo.setPrice(this.getPrice());

        if(!StringUtils.isEmpty(this.getLatitude()) && !StringUtils.isEmpty(this.getLongitude())) {
            Point point = new Point(this.getLatitude(), this.getLongitude());
            bannerInfo.setCoordinates(point);
        }

        return bannerInfo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Banner{");
        sb.append("id=").append(id);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", price=").append(price);
        sb.append(", label='").append(label).append('\'');
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
