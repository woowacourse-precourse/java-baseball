package baseball;

import baseball.Comparison;
import baseball.NumberChoice;
import baseball.GameOutput;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static final Integer WRONG_ANSWER = 0;
    public static final Integer NEW_GAME = 1;
    public static final Integer END_GAME = 2;

    public static Integer continueGame(List<Integer> result) {
        int strike = result.get(0);

        if (strike == 3) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            int choiceNum = Character.getNumericValue(choice.charAt(0));

            if (choiceNum == NEW_GAME) {
                playGame();
                return NEW_GAME;
            } else if (choiceNum == END_GAME) {
                return END_GAME;
            } else {
                System.out.println("잘못 입력하였습니다. 강제종료합니다.");
                return END_GAME;
            }
        }
        return WRONG_ANSWER;
    }

    public static void playGame() {
        int gameResult = 0;
        /* 숫자가 틀릴 때마다 computerPick을 실행시키면 컴퓨터 숫자가 바뀌므로
        do-while 문 밖에 위치시킨다 */
        List<Integer> computerNum = NumberChoice.computerPick();

        do {
            List<Integer> userNum = NumberChoice.userPick();
            List<Integer> compareResult = Comparison.compare(computerNum, userNum);
            GameOutput.printResult(compareResult);
            gameResult = continueGame(compareResult);
        } while (gameResult == WRONG_ANSWER);
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }
}
