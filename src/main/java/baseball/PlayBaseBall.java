package baseball;

public class PlayBaseBall {
    private Computer computer;
    private User user;
    private Messenger messenger;
    private AnswerChecker answerChecker;

    public void ready() {
        do {
            makeAnswer();
            start();
        } while (messenger.selectRepalyOrEnd(user.getUserOpinion()));
    }

    public void start() {
        do {
            enterNumber();
            checkAnswer();
            printMessage();
        } while (!answerChecker.isAnswer());
    }

    public void makeAnswer() {
        computer = new Computer();
        computer.makeAnswerNum();
    }

    public void enterNumber() {
        user = new User();
        user.inputNumber();
    }

    public void checkAnswer() {
        answerChecker = new AnswerChecker(computer.getAnswer());
        answerChecker.checkStrikeOrBall(user.getUserNumbers());
    }

    public void printMessage() {
        messenger = new Messenger();
        messenger.printResultMessage(answerChecker);
    }
}
