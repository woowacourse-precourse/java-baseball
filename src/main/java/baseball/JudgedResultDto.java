package baseball;

public class JudgedResultDto {

    private int countBalls;
    private int countStrikes;

    public JudgedResultDto(int countBalls, int countStrikes) {
        this.countBalls = countBalls;
        this.countStrikes = countStrikes;
    }

    public int getCountBalls() {
        return countBalls;
    }

    public int getCountStrikes() {
        return countStrikes;
    }
}
