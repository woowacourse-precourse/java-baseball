package domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static constant.Message.*;
import static constant.Rules.GAME_OVER;
import static constant.Rules.RESTART;
import static domain.Referee.STRIKE;

public class Game {

    public static void startGame() {
        System.out.println(GAME_START_MESSAGE);
        run();
    }

    public static void run() {
        while (true) {
            playGame();
            if (restartGame(GAME_OVER)) {
                System.out.println(PROGRAM_END_MESSAGE);
                break;
            }
        }
    }

    public static void playGame() {
        List<Integer> computer = Computer.getRandomNumbers();
        while (true) {
            System.out.print(INPUT_NUMBER_MESSAGE);
            String userNumber = Console.readLine();
            handleException(userNumber);
            String result = Referee.getJudgement(computer, User.getNumber(userNumber));
            System.out.println(result);

            if (result.equals(3 + STRIKE)) {
                winGame();
                break;
            }
        }
    }

    public static void winGame() {
        System.out.println(GAME_END_MESSAGE);
        System.out.println(GAME_RESTART_MESSAGE);
        String restartOrEnd = Console.readLine();
        restartGame(restartOrEnd);
    }

    public static boolean restartGame(String restartOrEnd) {
        if (restartOrEnd.equals(RESTART)) {
            playGame();
        }
        if (!(restartOrEnd.equals(RESTART) || restartOrEnd.equals(GAME_OVER))) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
        return true;
    }

    public static void handleException(String input){
        InputException.outOfRange(input);
        InputException.repeatNumber(input);
        InputException.excludeOneToNine(input);
    }

}
