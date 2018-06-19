package utility;

import domain.EventType;

import java.text.DateFormat;
import java.util.Date;


public class Event {
    private int id = (int) Math.random();
    private String msg;
    private Date date;
    private DateFormat df;
    private EventType eventType;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getMsg() {
        return msg;
    }

    public EventType getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
