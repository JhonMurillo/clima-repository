/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.admin.gateway;

import java.util.logging.Logger;
import javax.servlet.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author DESARROLLO
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class AdminGateway {

    private static final Logger LOG = Logger.getLogger(AdminGateway.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(AdminGateway.class, args);
        LOG.info("INICIO -- > AdminGateway");
    }

    @Bean
    public Filter shallowEtagHeaderFilter() {
        return new SimpleCORSFilter();
    }
}
