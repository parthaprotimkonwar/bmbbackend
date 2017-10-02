package com.bookmybanner;

import com.bookmybanner.models.BannerAttributes;
import com.bookmybanner.models.STATUS;
import com.bookmybanner.models.UserInfo;
import com.bookmybanner.models.document.BannerInfo;
import com.bookmybanner.models.repository.BannerInfoRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

import java.math.BigInteger;

/**
 * Created by parthaprotimkonwar on 01/04/17.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    private static final Point INDIRANAGAR = new Point(12.971891, 77.641151);
    private static final Point KORAMANGALA = new Point(12.927923, 77.627108);
    private static final Point MARATHALLI = new Point(12.959172, 77.697419);
    private static final Point HEBBAL = new Point(13.035770, 77.597022);
    private static final Point BENGALURU_AIRPORT = new Point(13.198635, 77.706593);

    private final Distance TEN_KMS = new Distance(7, Metrics.KILOMETERS);

    @Autowired
    BannerInfoRepository bannerInfoRepository;

    @Bean
    InitializingBean seedDatabase() {
        return () -> {
            bannerInfoRepository.deleteAll();
            bannerInfoRepository.save(new BannerInfo(new BannerAttributes("indiranagr", 12, 14, "description"), 12.0, INDIRANAGAR, STATUS.ACTIVE, new UserInfo(new BigInteger("1"), "partha", "990087765", "pkonwar@gmail.com")));


            bannerInfoRepository.save(new BannerInfo(new BannerAttributes("kormangala", 12, 14, "description"), 12.0, KORAMANGALA, STATUS.ACTIVE, new UserInfo(new BigInteger("2"), "dhadhuk", "990087765", "dhadhuk@gmail.com")));
            bannerInfoRepository.save(new BannerInfo(new BannerAttributes("marathalli", 12, 14, "marath desc"), 12.0, MARATHALLI, STATUS.ACTIVE, new UserInfo(new BigInteger("3"), "rishi", "990087765", "rishi@gmail.com")));
            bannerInfoRepository.save(new BannerInfo(new BannerAttributes("hebbal", 12, 14, "hebbal desc"), 12.0, HEBBAL, STATUS.ACTIVE, new UserInfo(new BigInteger("4"), "balli", "990087765", "balli@gmail.com")));
            bannerInfoRepository.save(new BannerInfo(new BannerAttributes("airport", 12, 14, "airport desc"), 12.0, BENGALURU_AIRPORT, STATUS.ACTIVE, new UserInfo(new BigInteger("5"), "airpoty", "990087765", "airpoty@gmail.com")));


        };
    }

    /*@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }*/

   /* @Autowired
    private UserBannersRepository userBannersRepository;

    private static final Point INDIRANAGAR = new Point(12.971891, 77.641151);
    private static final Point KORAMANGALA = new Point(12.927923, 77.627108);
    private static final Point MARATHALLI = new Point(12.959172, 77.697419);
    private static final Point HEBBAL = new Point(13.035770, 77.597022);
    private static final Point BENGALURU_AIRPORT = new Point(13.198635, 77.706593);

    private final Distance TEN_KMS = new Distance(7, Metrics.KILOMETERS);

    @Bean
    InitializingBean seedDatabase() {
        return () -> {
            usersRepository.deleteAll();
            usersRepository.save(new Users( "partha", INDIRANAGAR));
            usersRepository.save(new Users("dhadhuk", KORAMANGALA));
            usersRepository.save(new Users( "rishi", MARATHALLI));
            usersRepository.save(new Users( "balli", HEBBAL));
            usersRepository.save(new Users("pilot", BENGALURU_AIRPORT));


            userBannersRepository.deleteAll();

            List<BannerInfo> bannerInfos = new ArrayList<>();
            bannerInfos.add(new BannerInfo(12L,14L,1200.0,INDIRANAGAR, "banner in indiranagar", "active"));
            bannerInfos.add(new BannerInfo(13L,15L,1300.0,KORAMANGALA, "banner in kormangala", "active"));
            bannerInfos.add(new BannerInfo(14L,13L,1500.0,MARATHALLI, "banner in marathalli", "active"));


            List<BannerInfo> otherBannerInfos = new ArrayList<>();
            otherBannerInfos.add(new BannerInfo(12L,14L,1200.0,HEBBAL, "banner in hebbal", "active"));
            otherBannerInfos.add(new BannerInfo(13L,15L,1300.0,BENGALURU_AIRPORT, "banner in airport", "active"));

            userBannersRepository.save(new UserBanners("partha","partha@gmail.com","9900059924", "indirangar", "active", bannerInfos));
            userBannersRepository.save(new UserBanners("rishi","rishi@gmail.com","9900059924", "mrathalli", "active", otherBannerInfos));
        };
    }

    @Autowired
    private MongoConfiguration temp;

    @Bean
    CommandLineRunner exampleQuery() {

        return (args) -> {
            //usersRepository.findByPositionNear(INDIRANAGAR, TEN_KMS).forEach(System.err :: println);

            GeoResults<UserBanners> userBannersGeoResults = userBannersRepository.findByBannersCoordinatesNear(INDIRANAGAR, TEN_KMS);

            *//*for(GeoResult userBanners : userBannersGeoResults) {
                userBanners.
            }*//*
            //conf.mongoTemplate().

           *//* Aggregation agg = Aggregation.newAggregation(
                    match(Criteria.where("banners.coordinates").near(INDIRANAGAR).maxDistance(7)),
                    unwind("banners"),
                    match(Criteria.where("banners.coordinates").near(INDIRANAGAR).maxDistance(7)),
                    group().addToSet("banners").as("content")
            );


            AggregationResults<BannerInfoService> groupResults
                    = temp.mongoTemplate().aggregate(agg, UserBanners.class, BannerInfoService.class);
            List<BannerInfoService> result1 = groupResults.getMappedResults();

            System.out.println(result1);*//*

        };
    }*/


}
