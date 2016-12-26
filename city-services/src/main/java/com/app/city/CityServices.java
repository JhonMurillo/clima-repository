/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.city;

import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.jms.annotation.EnableJms;

/**
 *
 * @author DESARROLLO
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableJms
public class CityServices {

    private static final Logger LOG = Logger.getLogger(CityServices.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CityServices.class, args);
        LOG.info("INICIO -- > CityServices");
    }

}
