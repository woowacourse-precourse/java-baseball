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

        } while (messenger.selectRepalyOrEnd(user.getUserOpinion()));
    }
}
