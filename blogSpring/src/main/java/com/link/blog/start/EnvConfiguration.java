package com.link.blog.start;

import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @author dl-nest
 * @apiNote
 * @date 2021/12/8 13:20
 */
@Configuration
public class EnvConfiguration{

    @EventListener
    public void envListener(EnvironmentChangeEvent event) {
        System.out.println("conf change: " + event.getSource().toString());
        System.out.println("conf change: " + event.getClass());
    }
}