package baseball.io;

import baseball.game.model.BallCount;

public class OutputConsole implements Output{

    @Override
    public void print(Message message) {
        System.out.print(message.getMessage());
    }

    @Override
    public void print(BallCount ballCount) {
        System.out.println(ballCount.toString());
    }

    @Override
    public void print(int count) {
        System.out.print(count + Message.CORRECT.getMessage());
    }
}
