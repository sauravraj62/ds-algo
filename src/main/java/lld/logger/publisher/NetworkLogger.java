package lld.logger.publisher;

public class NetworkLogger implements LogPublisher{

    @Override
    public void update() {
        System.out.println("Writting from NetworkLogger");
    }
}
