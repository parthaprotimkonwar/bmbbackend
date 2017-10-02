package com.bookmybanner.controller;

import com.bookmybanner.application.constants.ApplicationConstants;
import com.bookmybanner.application.exception.types.DatabaseException;
import com.bookmybanner.application.exception.ErrorConstants;
import com.bookmybanner.application.exception.types.RESTException;
import com.bookmybanner.controller.models.Banner;
import com.bookmybanner.models.document.BannerInfo;
import com.bookmybanner.services.BannerInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by parthaprotimkonwar on 05/04/17.
 */
@RestController
public class BannerInfoController {

    @Autowired
    BannerInfoService bannerInfoService;

    Logger logger = LoggerFactory.getLogger(BannerInfoController.class.getName());

    @RequestMapping(value = "/banner/search", method = RequestMethod.GET,
            params = {"latitude", "longitude", "distance"})
    public List<BannerInfo> searchBanner(@RequestParam("latitude") double latitude,
                                         @RequestParam("longitude") double longitude,
                                         @RequestParam("distance") int distance) throws RESTException, DatabaseException{

        try {
            logger.info("Entering inside searchBanner");
            Distance radius = new Distance(distance, Metrics.KILOMETERS);

            logger.info("The radius is : {}", radius);
            //Point INDIRANAGAR = new Point(12.971891, 77.641151);

            Point source = new Point(latitude, longitude);
            logger.info("The source is : {}", source);

            return bannerInfoService.getBanners(source, radius);
        } catch (DatabaseException databaseException) {
            throw databaseException;
        } catch (Exception ex) {
            logger.error("Exception in SearchBanner. Trace {} ", ex);
            ErrorConstants error = ErrorConstants.BANNER_SEARCH_EXCEPTION;
            throw new RESTException(error.getErrorCode(), error.getErrorMessage());
        }
    }


    @RequestMapping(value = "/banner/create", method = RequestMethod.POST)
    public ResponseEntity createBanner(@Valid @RequestBody final Banner banner,
                                       @RequestHeader(ApplicationConstants.USER_ID) String userId) throws RESTException, DatabaseException{
        logger.info("Inside createBanner");
        try {
            BigInteger actualUserId = StringUtils.isEmpty(userId) ? null : new BigInteger(userId);
            bannerInfoService.saveBanner(banner.toBannerInfo(), actualUserId);
            logger.info("Banner save is successful");
        } catch (DatabaseException ex) {
            throw ex;
        } catch (Exception ex) {
            logger.error("Exception in SearchBanner. Trace {} ", ex);
            ErrorConstants error = ErrorConstants.BANNER_CREATE_EXCEPTION;
            throw new RESTException(error.getErrorCode(), error.getErrorMessage());
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "banner/update", method = RequestMethod.PUT)
    public ResponseEntity updateBanner(@Valid @RequestBody final Banner banner) throws RESTException, DatabaseException{
        logger.info("Inside updateBanner");
        boolean bannerUpdated = false;
        try {
            bannerUpdated = bannerInfoService.updateBanner(banner.toBannerInfo());
            logger.info("Successfully updated banner");
        } catch (DatabaseException ex) {
            throw ex;
        } catch (Exception ex) {
            logger.error("Exception in SearchBanner. Trace {} ", ex);
            ErrorConstants error = ErrorConstants.BANNER_UPDATE_EXCEPTION;
            throw new RESTException(error.getErrorCode(), error.getErrorMessage());
        }
        logger.info("Exiting method updateBanner");
        return bannerUpdated ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "banner/delete/{bannerId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBanner(@PathVariable BigInteger bannerId) throws RESTException, DatabaseException{
        logger.info("Inside deleteBanner");
        try {
            bannerInfoService.deleteBanner(bannerId);
            logger.info("Successfully deleted banner id {}", bannerId);
        }catch (DatabaseException ex) {
            throw ex;
        } catch (Exception ex) {
            logger.error("Exception in SearchBanner. Trace {} ", ex);
            ErrorConstants error = ErrorConstants.BANNER_DELETE_EXCEPTION;
            throw new RESTException(error.getErrorCode(), error.getErrorMessage());
        }
        logger.info("Exiting deleteBanner");
        return new ResponseEntity(HttpStatus.OK);
    }
}
