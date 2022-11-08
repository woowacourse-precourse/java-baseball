package baseball;

public class BaseballGameManager {
    private int answer;

    public void playGame() {
        this.answer = RandomAnswerGenerator.getRandomAnswer();

        while(true) {
            int inputNum = IOManager.inputNumber();

            if(new AnswerCompareManager().compareAnswer(answer, inputNum)) {
                IOManager.correctAnswer();
                break;
            }
        }
    }
}
