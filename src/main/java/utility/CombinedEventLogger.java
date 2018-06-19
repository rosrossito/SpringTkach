package utility;

import java.util.ArrayList;
import java.util.List;

public class CombinedEventLogger implements EventLogger {

    List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        loggers.stream().forEach(eventLogger -> eventLogger.logEvent(event));
    }
}
