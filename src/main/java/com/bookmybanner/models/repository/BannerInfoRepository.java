package com.bookmybanner.models.repository;

import com.bookmybanner.models.document.BannerInfo;
import com.bookmybanner.models.document.Users;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by parthaprotimkonwar on 04/04/17.
 */
public interface BannerInfoRepository extends MongoRepository<BannerInfo, BigInteger>{

    List<BannerInfo> findByCoordinatesNear(Point point, Distance distance);
}
