package baseball;

public enum Result {
    NOTHING("낫싱", 0),
    BALL("볼", 0),
    STRIKE("스트라이크", 0);

    private String name;
    private int frequency;


    Result(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    public String getName() {
        return this.name;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public void increaseFrequency() {
        this.frequency++;
    }

    public boolean verifyOccurrence() {
        if (this.frequency > 0) {
            return true;
        }
        return false;
    }

    public boolean verifyThreeTimes() {
        if (this.frequency == 3) {
            return true;
        }
        return false;
    }

    public void initFrequency() {
        this.frequency = 0;
    }

    public static void initAllFrequency() {
        NOTHING.initFrequency();
        BALL.initFrequency();
        STRIKE.initFrequency();
    }
}
