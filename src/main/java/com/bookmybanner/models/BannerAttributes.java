package com.bookmybanner.models;

import com.bookmybanner.models.constraints.Mergeable;
import com.google.common.base.Objects;

/**
 * Created by parthaprotimkonwar on 04/04/17.
 */
public class BannerAttributes implements Mergeable<BannerAttributes>{

    private String label;
    private Integer height;
    private Integer width;
    private String description;

    public BannerAttributes() {}

    public BannerAttributes(String label, int height, int width, String description) {
        this.label = label;
        this.height = height;
        this.width = width;
        this.description = description;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public BannerAttributes merge(BannerAttributes otherBannerAttribute) {
        if(otherBannerAttribute == null) return this;
        if(otherBannerAttribute.getLabel() != null) setLabel(otherBannerAttribute.getLabel());
        if(otherBannerAttribute.getHeight() != null) setHeight(otherBannerAttribute.getHeight());
        if(otherBannerAttribute.getWidth() != null) setHeight(otherBannerAttribute.getHeight());
        if(otherBannerAttribute.getDescription() != null) setDescription(otherBannerAttribute.getDescription());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BannerAttributes that = (BannerAttributes) o;
        return Objects.equal(getLabel(), that.getLabel()) &&
                Objects.equal(getHeight(), that.getHeight()) &&
                Objects.equal(getWidth(), that.getWidth()) &&
                Objects.equal(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLabel(), getHeight(), getWidth(), getDescription());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BannerAttributes{");
        sb.append("label='").append(label).append('\'');
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
