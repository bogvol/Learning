package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;
import org.springframework.stereotype.Component;


@Component
public class ConsoleEventLogger extends AbstractLogger {

//    public void logEvent(String msg) {
//        System.out.println(msg);
//    }

    @Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
