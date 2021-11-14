package lld.logger;

import java.util.HashMap;
import java.util.Map;

public class LoggerClient extends Logger{
    Map<Severity, Boolean> enabledSeverityMap = new HashMap<>();

    LoggerClient() {
        enabledSeverityMap.put(Severity.INFO, true);
        enabledSeverityMap.put(Severity.WARNING, true);
        enabledSeverityMap.put(Severity.ERROR, true);
    }

    public void writeLog(Severity severity, String data) {
        if(enabledSeverityMap.get(severity)) {
            setData(data);
            this.notify(severity);
        }
    }

    public void enablePublisher(Severity severity) {
        enabledSeverityMap.put(severity, true);
    }

    public void disablePublisher(Severity severity) {
        enabledSeverityMap.put(severity, false);
    }
}
