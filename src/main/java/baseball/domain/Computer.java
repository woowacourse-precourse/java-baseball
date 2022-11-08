package baseball.domain;


public class Computer {
    private Balls answer;

    public void generateAnswer() {
        this.answer = Balls.generateUniqueBalls();
    }

    public int getStrike(Balls player) {
        return answer.equalsExactly(player);
    }

    public int getBall(Balls player) {
        return answer.containsCountWithoutEqual(player);
    }
}
