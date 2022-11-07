package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static final String GAME_START_TEXT = "숫자 야구 게임을 시작합니다.";
    private static final String ANSWER_INPUT_TEXT = "숫자를 입력해주세요 : ";
    private static final String CONTINUE_INPUT_TEXT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;
    private static final int CONTINUE = 1;

    public static void main(String[] args) {
        Computer computer = new Computer();
        boolean isContinue;
        System.out.println(GAME_START_TEXT);

        do {
            isContinue = gameLoop(computer);
        } while (isContinue);
    }

    private static boolean gameLoop(Computer computer) {
        boolean isContinue;
        isContinue = false;
        computer.selectRandomNumbers();
        while (true) {
            System.out.print(ANSWER_INPUT_TEXT);
            String playerAnswer = readLine();
            Player.isValidAnswer(playerAnswer);

            List<Integer> compareResult = computer.compare(Integer.valueOf(playerAnswer));
            Integer strike = compareResult.get(STRIKE_INDEX);
            Integer ball = compareResult.get(BALL_INDEX);
            computer.printResult(strike, ball);

            if (strike.equals(3)) {
                isContinue = gameEnd(isContinue);
                break;
            }
        }
        return isContinue;
    }

    private static boolean gameEnd(boolean isContinue) {
        String playerAnswer;
        System.out.println(CONTINUE_INPUT_TEXT);
        playerAnswer = readLine();
        Player.isValidContinueAnswer(playerAnswer);
        if (Integer.parseInt(playerAnswer) == CONTINUE) {
            isContinue = true;
        }
        return isContinue;
    }

    public static List<Integer> convertToList(Integer number) {
        List<Integer> result = new ArrayList<>();

        for (String s : number.toString().split("")) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
}
