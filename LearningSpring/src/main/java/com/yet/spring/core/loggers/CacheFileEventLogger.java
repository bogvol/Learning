package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;

import java.util.ArrayList;
import java.util.List;

//@Component
public class CacheFileEventLogger extends FileEventLogger {

    // Use system property cache.size or 5 if property is not set
//    @Value("${cache.size:5}")
    private int cacheSize;
    private List<Event> cache;

//    public CacheFileEventLogger() {
//    }

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<>(cacheSize);
    }

//    @PostConstruct
//    public void initCache() {
//        this.cache = new ArrayList<Event>(cacheSize);
//    }

//    @PreDestroy
    public void destroy() {
        if (!cache.isEmpty())
            writeEventsFromCache();
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
//        cache.stream().forEach(super::logEvent);
//        cache.stream().forEach(e->super.logEvent(e));
        for(Event e: cache) {
            super.logEvent(e);
        }
    }

}
