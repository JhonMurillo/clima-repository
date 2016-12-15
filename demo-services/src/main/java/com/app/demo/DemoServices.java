/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo;

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
public class DemoServices {

    private static final Logger LOG = Logger.getLogger(DemoServices.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoServices.class, args);
        LOG.info("INICIO -- > DemoServices");
    }

}