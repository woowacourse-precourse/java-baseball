package baseball;

public class PlayBaseBall {
    private Computer computer;
    private User user;
    private Messenger messenger;

    public PlayBaseBall() {
    }

    public void ready() {
        do {
            this.computer = new Computer();
            computer.makeAnswerNum();
            start();
        } while (messenger.selectRepalyOrEnd(user.getUserOpinion()));
    }

    public void start() {
        AnswerChecker answerChecker;
        do {
            this.user = new User();
            this.messenger = new Messenger();
            user.inputNumbers();
            answerChecker = new AnswerChecker(computer.getAnswer());
            answerChecker.checkStrikeOrBall(user.getUserNumbers());
            messenger.printResultMessage(answerChecker);
        } while (!answerChecker.isAnswer());
    }
}
