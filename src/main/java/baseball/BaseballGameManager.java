package baseball;

public class BaseballGameManager {
    private int answer;

    public void playGame() {
        this.answer = RandomAnswerGenerator.getRandomAnswer();

        while(true) {
            int inputNum = IOManager.inputNumber();

            // compare & print hint

            if(inputNum == answer) {
                IOManager.correctAnswer();
                break;
            }
        }
    }
}
