package com.bookmybanner.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by parthaprotimkonwar on 01/04/17.
 */
@Configuration
public class FactoryConfiguration {

    @Bean
    public String startServerDetails() {
        //System.out.println("********Application Started in port 9090*******");
        return "8080";
    }
}
