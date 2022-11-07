package baseball;

public class PlayBaseBall {
    private Computer computer;
    private User user;
    private Messenger messenger;
    private AnswerChecker answerChecker;


    // - 게임 진행 - //

    public void ready() {
        do {
            makeAnswer();
            start();
        } while (userWantsReplay());
    }

    public void start() {
        do {
            enterNumber();
            checkAnswer();
            printMessage();
        } while (isNotAnswer());
    }


    // - 게임 진행 기능 리스트 - //

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

    public boolean userWantsReplay() {
        return messenger.selectRepalyOrEnd(user.getUserOpinion());
    }

    public boolean isNotAnswer() {
        return !answerChecker.isAnswer();
    }
}
