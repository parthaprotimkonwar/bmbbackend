package com.bookmybanner.services.impl;

import com.bookmybanner.application.exception.ErrorConstants;
import com.bookmybanner.application.exception.types.DatabaseException;
import com.bookmybanner.models.document.BannerInfo;
import com.bookmybanner.models.document.Users;
import com.bookmybanner.models.repository.BannerInfoRepository;
import com.bookmybanner.services.BannerInfoService;
import com.bookmybanner.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by parthaprotimkonwar on 04/04/17.
 */
@Service
public class BannerInfoServiceImpl implements BannerInfoService {

    @Autowired
    private BannerInfoRepository bannerInfoRepository;

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(BannerInfoServiceImpl.class.getName());

    @Override
    public List<BannerInfo> getBanners(Point source, Distance distance) throws DatabaseException {
        try {
            logger.info("Inside method getBanners");
            return bannerInfoRepository.findByCoordinatesNear(source, distance);
        } catch (Exception ex) {
            logger.error("Exception occured while getting banners. Trace : {}" , ex);
            ErrorConstants error = ErrorConstants.DATA_FETCH_EXCEPTION;
            throw new DatabaseException(error.getErrorCode(), error.getErrorMessage());
        }
    }

    @Override
    public Boolean saveBanner(BannerInfo bannerInfo, BigInteger userId) throws DatabaseException {
        boolean bannerSaved = false;
        try {
            logger.info("Inside method saveBanner");

            Users users = userService.findOne(userId);
            //merge the generated user data with existing data
            bannerInfo.getUserInfo().merge(users.toUserInfo());

            bannerInfo = bannerInfoRepository.save(bannerInfo);
            logger.info("Banner with id: {}, has been saved", bannerInfo.getBannerId());
            bannerSaved = true;
        } catch (Exception ex) {
            logger.error("Exception occured while saving banners. Trace : {}" , ex);
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new DatabaseException(error.getErrorCode(), error.getErrorMessage());
        }
        return bannerSaved;
    }

    @Override
    public Boolean updateBanner(BannerInfo bannerInfo) throws DatabaseException {
        boolean bannerUpdated = false;
        try {
            logger.info("Inside method updateBanner");
            BannerInfo existingBanner = bannerInfoRepository.findOne(bannerInfo.getBannerId());

            if (existingBanner != null) {
                existingBanner.merge(bannerInfo);
                bannerInfoRepository.save(existingBanner);
                bannerUpdated = true;
            } else {
                bannerInfoRepository.save(bannerInfo);
            }
        } catch (Exception ex) {
            logger.error("Exception occured while updating banners. Trace : {}" , ex);
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new DatabaseException(error.getErrorCode(), error.getErrorMessage());
        }
        return bannerUpdated;
    }

    @Override
    public Boolean deleteBanner(BigInteger bannerId) throws DatabaseException {
        boolean bannerDeleted = false;
        try {
            logger.info("Inside method deleteBanner");
            bannerInfoRepository.delete(bannerId);
            bannerDeleted = true;
        } catch (Exception ex) {
            logger.error("Exception occured while deleting banners. Trace : {}" , ex);
            ErrorConstants error = ErrorConstants.DATA_PERSISTANT_EXCEPTION;
            throw new DatabaseException(error.getErrorCode(), error.getErrorMessage());
        }
        return bannerDeleted;
    }
}
