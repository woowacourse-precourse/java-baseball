package baseball.playing;

import baseball.GameController;
import baseball.players.Computer;
import baseball.players.Player;
import baseball.players.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class PlayGame {

    private String computerNumber;
    private String userNumber;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Player player = new Computer();
        computerNumber = player.generateNumbers();
    }

    public void playingGame() {

        StrikeOrBall strikeOrBall = new StrikeOrBall();
        Map<String, Integer> getStrikeBall;

        while (true) {
            Player player = new User();
            userNumber = player.generateNumbers();
            String result = strikeOrBall.printStrikeOrBall(computerNumber, userNumber);
            System.out.println(result);

            getStrikeBall = strikeOrBall.checkStrikeOrBall(computerNumber, userNumber);
            if (getStrikeBall.get("Strike") == 3) {
                System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
                break;
            }
        }
    }

    public void endGame() {
        System.out.println("게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public boolean replayGame() {

        String replaying = Console.readLine();
        int replayNum = Integer.valueOf(replaying);

        checkInputErr(replayNum);

        if (replayNum == 2) {
            return false;
        }

        return true;
    }

    public void checkInputErr(int replayNum) throws IllegalArgumentException {
        if (!(replayNum == 1 || replayNum == 2))
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
    }
}
