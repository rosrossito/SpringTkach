import domain.Client;
import domain.EventType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utility.ConsoleEventLogger;
import utility.Event;
import utility.EventLogger;
import utility.FileEventLogger;

import java.util.Map;


public class App {
    Client client;
    EventLogger defaultLogger;
    Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger= eventLogger;
        this.loggers = loggers;
    }

    void logEvent(EventType type, Event event) {
        EventLogger logger = loggers.get(type);
        if (logger==null){
            logger=defaultLogger;
        }
        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");
        App app = (App) ctx.getBean("app");
        Event event = (Event) ctx.getBean("event");
        event.setMsg("Some event for user 1");
        event.setEventType(EventType.INFO);
        app.logEvent(event.getEventType(), event);

        event.setMsg("Some event for user 2");
        event.setEventType(EventType.ERROR);
        app.logEvent(event.getEventType(), event);

        ctx.close();
    }
}
