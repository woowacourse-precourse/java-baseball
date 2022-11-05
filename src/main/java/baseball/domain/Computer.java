package baseball.domain;


public class Computer {
    private Balls answer;

    public void generateAnswer() {
        this.answer = Balls.generateUniqueBalls();
    }

}
