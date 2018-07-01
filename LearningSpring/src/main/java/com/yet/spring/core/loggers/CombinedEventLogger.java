package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;

import java.util.Collection;
import java.util.Collections;

//@Component
public class CombinedEventLogger extends AbstractLogger {

    //    @Resource(name = "combinedLoggers")
    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }
    }

    public Collection<EventLogger> getLoggers() {
        return Collections.unmodifiableCollection(loggers);
    }
}
