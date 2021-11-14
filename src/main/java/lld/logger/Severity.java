package lld.logger;

public enum Severity {
    INFO(1),
    WARNING(2),
    ERROR(3);

    Severity(int level) {
        this.level = level;
    }

    private int level;

    public int getLevel() {
        return level;
    }
}
