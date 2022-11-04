package baseball.playing;

import baseball.players.Computer;
import baseball.players.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class PlayGame {

    private String computerNumber;
    private String userNumber;

    public PlayGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void startGame() {
        Computer computer = new Computer();
        computerNumber = computer.getComputerNumbers();
        playingGame();
    }

    public void playingGame() {
        StrikeOrBall strikeOrBall = new StrikeOrBall();
        Map<String, Integer> strikeBall = new HashMap<>();

        while (true) {
            inputUserNumbers();
            String result = strikeOrBall.printStrikeOrBall(computerNumber, userNumber);
            System.out.println(result);

            strikeBall = strikeOrBall.checkStrikeOrBall(computerNumber, userNumber);
            if (strikeBall.get("Strike") == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        replayingGame();
    }

    private void replayingGame() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String replaying = Console.readLine();
        int replayNumber = Integer.parseInt(replaying);
        checkInputErr(replayNumber);

        if (replayNumber == 1) {
            startGame();
        }
    }

    private void checkInputErr(int replayNumber) throws IllegalArgumentException {
        if (!(replayNumber == 1 || replayNumber == 2))
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
    }

    private void inputUserNumbers() {

        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        User user = new User(inputNumber);

        userNumber = user.getUserNumbers();
    }
}
