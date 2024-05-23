package labTwo.dataStructures.studentManager.models;

public enum YearLevel {
    FRESHER(6),
    SOPHOMORE(7),
    JUNIOR(8),
    SENIOR(8);

    private final int defaultValue;

    YearLevel(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    public int getDefaultValue() {
        return defaultValue;
    }
}
