package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.CheckException;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameService {
    private static Computer computer;
    private static User user;
    private static Game game;

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        game = new Game();
        computer = new Computer();
        user = new User();
        while (game.getStrikeCount() != 3) {
            playGame();
            printResultMessage(game.getBallCount(), game.getStrikeCount());
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void playGame() {
        game.initializeGame();
        user.setUserNumbers(getUserNumbers());
        compareNumbers(computer.getNumbers(), user.getUserNumbers());
    }

    private static List<Integer> getUserNumbers() throws IllegalArgumentException {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = Console.readLine();
        return CheckException.checkUserInput(input);
    }

    private static void compareNumbers(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            int number = computerNumbers.get(i);
            if (userNumbers.get(i) == number) {
                game.setStrikeCount(1);
                continue;
            }
            if (userNumbers.contains(number)) {
                game.setBallCount(1);
            }
        }
    }

    private static void printResultMessage(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
