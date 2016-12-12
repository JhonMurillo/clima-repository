/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.eureka.server;

import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author DESARROLLO
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {

    private static final Logger LOG = Logger.getLogger(EurekaServer.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class, args);
        LOG.info("INICIO -- > EurekaServer");
    }
}
