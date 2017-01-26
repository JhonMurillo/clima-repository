/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.scheduledTask;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 * @author DESARROLLO
 */
public class TaskUser {

    private static final Logger LOG = Logger.getLogger(TaskUser.class.getName());

    @Scheduled(cron = "15 * * * * ")
    public void taksUser() {
        System.out.println("Hola Mundo " + new Date());
        LOG.log(Level.INFO, "Hola Mundo {0}", new Date());
    }

}
