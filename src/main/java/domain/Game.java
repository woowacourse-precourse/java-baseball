package domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static domain.Referee.STRIKE;

public class Game {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String PROGRAM_END_MESSAGE = "프로그램이 종료되었습니다.";

    public static void startGame() {
        System.out.println(GAME_START_MESSAGE);
        run();
    }

    public static void run() {
        while (true) {
            playGame();
            if (restartGame("2")) {
                System.out.println(PROGRAM_END_MESSAGE);
                break;
            }
        }
    }

    public static void playGame() {
        List<Integer> COMPUTER_NUMBERS = Computer.getRandomNumbers();
        while (true) {
            System.out.print(INPUT_NUMBER_MESSAGE);
            String userNumber = Console.readLine();
            handleException(userNumber);

            String result = Referee.getJudgement(COMPUTER_NUMBERS, User.getUserNumber(userNumber));
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
        if (restartOrEnd.equals("1")) {
            playGame();
        }
        if (!(restartOrEnd.equals("1") || restartOrEnd.equals("2"))) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static void handleException(String input){
        InputException.outOfRange(input);
        InputException.repeatNumber(input);
        InputException.excludeOneToNine(input);
    }

}
