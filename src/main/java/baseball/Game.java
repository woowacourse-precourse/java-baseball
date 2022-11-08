package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.Texts;

import java.util.List;

public class Game {
    Computer computer;
    User user;

    public Game() {
        computer = new Computer();
        user = new User();
    }

    public void run() {
        System.out.println(Texts.GAME_BEGIN);
        while (true) {
            play();
            System.out.println(Texts.GAME_RESTART);
            String inputCase = Console.readLine();
            if (inputCase.equals("1")) {
                continue;
            } else if (inputCase.equals("2")) {
                break;
            } else {
                throw new IllegalArgumentException(Texts.USER_INPUT_ILLEGAL_NOT_1_OR_2 + Texts.USER_INPUT_ILLEGAL + Texts.GAME_END);
            }
        }
        System.out.println(Texts.GAME_END);
    }

    public void play() {
        computer.makeComputerNumber();
        List<Integer> result;
        List<Integer> computerNumbers;
        computerNumbers = computer.getNumber();
        do {
            user.makeUserNumber();
            Checker checker = new Checker();
            List<Integer> userNumbers = user.getNumber();
            result = checker.checkByDigit(userNumbers, computerNumbers);
            String score = checker.checkResult(result);
            System.out.println(score);
        } while (result.get(0) < 3);
        System.out.println(Texts.GAME_PLAY_WIN);
    }
}
