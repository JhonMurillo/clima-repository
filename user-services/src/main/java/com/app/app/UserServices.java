/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app;

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
public class UserServices {

    private static final Logger LOG = Logger.getLogger(UserServices.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(UserServices.class, args);
        LOG.info("INICIO -- > UserServices");
    }
}
