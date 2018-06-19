package utility;

import java.util.List;
import java.util.function.Consumer;

public class CacheFileEventLogger extends FileEventLogger {
    int cacheSize;
    List<Event> cache;

    public CacheFileEventLogger(int cacheSize, String filename) {
        super(filename);
        this.cacheSize = cacheSize;
    }

    public void logEvent(Event event){
        cache.add(event);

        if (cache.size()==cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    public void destroy(){
        if (!cache.isEmpty()){
            writeEventsFromCache();
        }
    }

    void writeEventsFromCache(){
        cache.stream().
                forEach(e->super.logEvent(e));
    }
}
