/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather;

import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author DESARROLLO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WeatherServices {
    private static final Logger LOG = Logger.getLogger(WeatherServices.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(WeatherServices.class, args);
        LOG.info("INICIO -- > WeatherServices");
    }
}
