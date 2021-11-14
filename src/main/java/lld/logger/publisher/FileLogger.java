package lld.logger.publisher;

public class FileLogger implements LogPublisher{

    private String fileName;

    public FileLogger(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void update() {
        System.out.println("Writting from FileLogger, fileName : " + fileName);
    }
}
