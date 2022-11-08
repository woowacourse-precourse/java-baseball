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

        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            playerInput();
        } catch (IllegalArgumentException e) {
            this.again = false;
            throw new IllegalArgumentException();
        }
    }

    public void playerInput() throws IllegalArgumentException {
        List<String> playerAnswer = this.player.inputAnswer();
        computerGiveHint(playerAnswer);
    }

    public void computerGiveHint(List<String> playerAnswer) {
        List<String> hint = this.computer.giveHint(playerAnswer);
        printHint(hint);
    }

    public void printHint(List<String> hint) {
        String announcement = makeAnnouncement(hint);
        System.out.println(announcement);

        if (hint.get(1).equals("3")) {
            answerCorrect();
        }
    }

    public String makeAnnouncement(List<String> hint) {
        String ball = concatBall(hint.get(0));
        String strike = concatStrike(hint.get(1));

        if (ball.equals("")) {
            if (strike.equals("")) {
                return "낫싱";
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
        return ball.concat("볼");
    }

    public String concatStrike(String strike) {
        if (strike.equals("0")) {
            return "";
        }
        return strike.concat("스트라이크");
    }

    public void answerCorrect() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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
        System.out.println("잘못 입력하셨습니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        askPlayAgain();
    }
}
