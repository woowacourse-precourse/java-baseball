package baseball;

import java.util.List;

public class Game {
    //  reduce instance vars? after fixing the way to restart the game
    public Boolean again;
    public Computer computer;
    public Player player;

    public void start() {
        this.again = true;
        this.computer = new Computer();
        this.player = new Player();

        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() throws IllegalArgumentException {
        while (this.again) {
            System.out.println("숫자를 입력해주세요 : ");
            playerInput();
        }
        //TODO player input 1 or 2 to play again or not
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

    // 정리좀...
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
        //TODO input (2 -> this.again = false)
    }
}
