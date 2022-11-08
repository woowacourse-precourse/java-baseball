package baseball;

public class JudgedResultDto {

    private int countBalls;
    private int countStrikes;

    private JudgedResultDto(int countBalls, int countStrikes) {
        this.countBalls = countBalls;
        this.countStrikes = countStrikes;
    }

    public static JudgedResultDto makeNormalDto(int countBalls, int countStrikes) {
        return new JudgedResultDto(countBalls, countStrikes);
    }

    public static JudgedResultDto makeNothingDto() {
        return new JudgedResultDto(0, 0);
    }

    public static JudgedResultDto make3StrikeDto() {
        return new JudgedResultDto(0, 3);
    }

    public int getCountBalls() {
        return countBalls;
    }

    public int getCountStrikes() {
        return countStrikes;
    }

    public boolean is3Strike() {
        return countStrikes == 3;
    }

    public boolean isNothing() {
        return countBalls == 0 && countStrikes == 0;
    }

    public boolean isOnlyBalls() {
        return countBalls > 0 && countStrikes == 0;
    }

    public boolean isOnlyStrikes() {
        return countBalls == 0 && countStrikes > 0;
    }
}
