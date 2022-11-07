package baseball.domain;

import java.util.List;

public class Count {

    List<String> computerAnswer;
    List<String> userAnswer;
    int size;
    public int ballResult;
    public int strikeResult;

    public Count(List<String> computerAnswer, List<String> userAnswer) {
        this.computerAnswer = computerAnswer;
        this.userAnswer = userAnswer;
        this.size = Computer.COMPUTER_NUMBER_SIZE;
        this.ballResult = 0;
        this.strikeResult = 0;
        count();
    }

    public void count() {
        for (int i = 0; i < size; i++) {
            isValidBall(i);
            isValidStrike(i);
        }
    }

    private void isValidBall(int index) {
        if (!computerAnswer.get(index).equals(userAnswer.get(index)) && computerAnswer.contains(userAnswer.get(index))){
            ballResult++;
        }
    }

    private void isValidStrike(int index) {
        if (computerAnswer.get(index).equals(userAnswer.get(index))) {
            strikeResult++;
        }
    }
}
