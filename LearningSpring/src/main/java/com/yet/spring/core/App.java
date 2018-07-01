package com.yet.spring.core;

import com.yet.spring.core.aspects.StatisticsAspect;
import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.beans.EventType;
import com.yet.spring.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Map.Entry;

//@Service
public class App {

    //    @Autowired
    private Client client;

    //    @Resource(name = "defaultLogger")
    //    private EventLogger eventLogger;
    private EventLogger defaultLogger;

    //    @Resource(name = "loggerMap")
    private Map<EventType, EventLogger> loggers;

    private String startupMessage;

    private StatisticsAspect statisticsAspect;

//    public App() {
//    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(AppConfig.class, LoggerConfig.class);
//        ctx.scan("com.yet.spring.core");
//        ctx.refresh();

        App app = (App) ctx.getBean("app");

        System.out.println(app.startupMessage);

//        app.client = new com.yet.spring.core.beans.Client("1", "John Smith");
//        app.defaultLogger = new com.yet.spring.core.loggers.ConsoleEventLogger();

        Client client = ctx.getBean(Client.class);
        System.out.println("Client says: " + client.getGreeting());

        Event event = ctx.getBean(Event.class);
//        app.logEvent(event, "Some event for 1");
//
//        event = ctx.getBean(Event.class);
//        app.logEvent(event, "Some event for 2");
        app.logEvent(EventType.INFO, event, "Some event for 1");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "One more event for 1");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "And one more event for 1");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Some event for 2");

        event = ctx.getBean(Event.class);
        app.logEvent(null, event, "Some event for 3");

        app.outputLoggingCounter();

        ctx.close();
    }

    App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        super();
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    private void logEvent(EventType eventType, Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = defaultLogger;
        }

        logger.logEvent(event);
    }

    private void outputLoggingCounter() {
        if (statisticsAspect != null) {
            System.out.println("Loggers statistics. Number of calls: ");
            for (Entry<Class<?>, Integer> entry : statisticsAspect.getCounter().entrySet()) {
                System.out.println("    " + entry.getKey().getSimpleName() + ": " + entry.getValue());
            }
        }
    }

    public void setStartupMessage(String startupMessage) {
        this.startupMessage = startupMessage;
    }

    public void setStatisticsAspect(StatisticsAspect statisticsAspect) {
        this.statisticsAspect = statisticsAspect;
    }

    public EventLogger getDefaultLogger() {
        return defaultLogger;
    }
}
