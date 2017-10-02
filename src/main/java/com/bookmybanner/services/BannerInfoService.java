package com.bookmybanner.services;

import com.bookmybanner.application.exception.types.DatabaseException;
import com.bookmybanner.controller.models.Banner;
import com.bookmybanner.models.document.BannerInfo;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by parthaprotimkonwar on 04/04/17.
 */
public interface BannerInfoService {

    //Display the list of banners available
    List<BannerInfo> getBanners(Point source, Distance distance) throws DatabaseException;

    //save banner object
    Boolean saveBanner(BannerInfo banner, BigInteger userId) throws DatabaseException;

    //update banner object
    Boolean updateBanner(BannerInfo banner) throws DatabaseException;

    //delete a banner from the database
    Boolean deleteBanner(BigInteger bannerId) throws DatabaseException;
}
