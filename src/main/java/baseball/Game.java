package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
    public Boolean again;
    public Computer computer;
    public Player player;

    public void start() {
        this.again = true;
        this.computer = new Computer();
        this.player = new Player();

        System.out.println(Constant.START_MESSAGE);
    }

    public void play() {
        System.out.print(Constant.REQUEST_INPUT_ANSWER);
        try {
            Answer playerAnswer = this.player.inputAnswer();
            List<String> hint = this.computer.giveHint(playerAnswer);
            printHint(hint);
        } catch (IllegalArgumentException e) {
            this.again = false;
            throw new IllegalArgumentException();
        }
    }

    public void printHint(List<String> hint) {
        String announcement = makeAnnouncement(hint);
        System.out.println(announcement);
        if (hint.get(1).equals(Constant.ANSWER_SIZE)) {
            answerCorrect();
        }
    }

    public String makeAnnouncement(List<String> hint) {
        String ball = concatBall(hint.get(0));
        String strike = concatStrike(hint.get(1));
        if (ball.equals("")) {
            if (strike.equals("")) {
                return Constant.NOTHING;
            }
            return strike;
        }
        if (strike.equals("")) {
            return ball;
        }
        return ball.concat(" ").concat(strike);
    }

    public String concatBall(String ball) {
        if (ball.equals("0")) {
            return "";
        }
        return ball.concat(Constant.BALL);
    }

    public String concatStrike(String strike) {
        if (strike.equals("0")) {
            return "";
        }
        return strike.concat(Constant.STRIKE);
    }

    public void answerCorrect() {
        System.out.println(Constant.CORRECT_MESSAGE);
        System.out.println(Constant.ASK_RESTART_MESSAGE);
        askPlayAgain();
    }

    public void askPlayAgain() {
        String inputAnswer = Console.readLine();
        if (inputAnswer.equals("1")) {
            start();
            return;
        }
        if (inputAnswer.equals("2")) {
            this.again = false;
            return;
        }
        System.out.println("잘못 입력하셨습니다. " + Constant.ASK_RESTART_MESSAGE);
        askPlayAgain();
    }
}
