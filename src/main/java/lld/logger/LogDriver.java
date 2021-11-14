package lld.logger;

import lld.logger.publisher.ConsoleLogger;
import lld.logger.publisher.FileLogger;
import lld.logger.publisher.NetworkLogger;

public class LogDriver {
    public static void main(String args[]) {
        LoggerClient loggerClient = new LoggerClient();
        loggerClient.attachPublisher(Severity.INFO, new ConsoleLogger());
        loggerClient.attachPublisher(Severity.INFO, new FileLogger("newFile"));
        loggerClient.attachPublisher(Severity.INFO, new NetworkLogger());
        loggerClient.writeLog(Severity.INFO, "First log");
    }
}
