package lld.logger.publisher;

public class ConsoleLogger implements LogPublisher {

    @Override
    public void update() {
        System.out.println("Writting from ConsoleLogger");
    }
}
