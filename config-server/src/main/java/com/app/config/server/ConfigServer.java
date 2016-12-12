package com.app.config.server;

import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigServer {

    private static final Logger LOG = Logger.getLogger(ConfigServer.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer.class, args);
        LOG.info("INICIO -- > ConfigServer");
    }

}
