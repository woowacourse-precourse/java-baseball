package baseball.playing;

import baseball.GameController;
import baseball.players.Computer;
import baseball.players.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class PlayGame {

    private String computerNumber;
    private String userNumber;
    private String replaying;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        computerNumber = computer.getComputerNumbers();
    }

    public void playingGame() {
        StrikeOrBall strikeOrBall = new StrikeOrBall();
        Map<String, Integer> getStrikeBall;

        while (true){
            String input = inputUserNumbers();
            User user = new User(input);
            userNumber = user.getUserNumbers();
            String result = strikeOrBall.printStrikeOrBall(computerNumber, userNumber);
            System.out.println(result);

            getStrikeBall = strikeOrBall.checkStrikeOrBall(computerNumber, userNumber);
            if(getStrikeBall.get("Strike") == 3){
                System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
                break;
            }
        }
    }

    public void endGame() {
        System.out.println("게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        replaying = Console.readLine();
        checkInputErr(replaying);
        replayGame();
    }

    public void replayGame() {
            GameController gameController = new GameController();
    }

    public void checkInputErr(String replaying) throws IllegalArgumentException {
        int replayNum = Integer.parseInt(replaying);
        if (!(replayNum == 1 || replayNum == 2))
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
    }

    private String inputUserNumbers() {

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return input;
    }
}
