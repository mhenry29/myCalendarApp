package org.rebootu.mhenry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by melissa on 6/14/15.
 */
@SpringBootApplication
public class MyCalendarApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MyCalendarApplication.class, args);
    }

}
