package lld.logger;

import lld.logger.publisher.LogPublisher;

import java.util.*;

public class Logger {
    private Map<Severity, List<LogPublisher>> publishersBySeverity = new HashMap<>();
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void attachPublisher(Severity severity, LogPublisher logPublisher) {
        publishersBySeverity.computeIfAbsent(severity, k -> new ArrayList<>()).add(logPublisher);
    }

    public void detachPublisher(Severity severity, LogPublisher logPublisher) {
        if(publishersBySeverity.containsKey(severity)) {
            List<LogPublisher> logPublishers = publishersBySeverity.get(severity);
//            logPublishers.
        }
    }

    protected void notify(Severity severity) {
        if(publishersBySeverity.containsKey(severity)) {
            List<LogPublisher> logPublishers = publishersBySeverity.get(severity);
            logPublishers.forEach(LogPublisher::update);
        }
    }
}
