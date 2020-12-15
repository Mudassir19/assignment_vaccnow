package com.xebia.assignment_vacc.utility;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Vaccine_Schedular {

    @Scheduled(cron = "0 0/30 * * * * ?")
    public void mailScheduling() {
        System.out.println("scheduling vaccine on every 30 minutes:");
    }
}
